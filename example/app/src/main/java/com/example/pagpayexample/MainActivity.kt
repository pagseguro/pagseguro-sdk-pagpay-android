package com.example.pagpayexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.pagpay.checkout.core.common.ErrorApi
import com.pagpay.checkout.presentation.button.PagPayPaymentButton
import com.pagpay.checkout.presentation.checkout.CheckoutContract
import com.pagpay.checkout.presentation.checkout.Env
import com.pagpay.checkout.presentation.checkout.PagPay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), CheckoutContract.CallBack {

    lateinit var mainView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainView = findViewById(R.id.main_view)

        findViewById<PagPayPaymentButton>(R.id.button).setOnClickListener {
            val payWithPagPayClient = PagPay.newBuilder()
                .merchantInfo(createMerchantInfoRequest())
                .paymentRequest(createPaymentRequest(), this)
                .build()

            // Coroutine chamada diretamente como referência, dessa maneira pode gerar leaks caso a
            // Activity seja reconstruída, é necessário que se use alguma maneira de código async
            // fora da thread principal pois a API por baixo faz uma chamada de networking.
            // Ela trava a thread além de receber a exceção NetworkOnMainThreadException
            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    payWithPagPayClient.redirectPagBank(this@MainActivity, Env.SANDBOX)
                }
            }
        }
    }

    override fun onErrorToRedirect(error: ErrorApi) {
        Snackbar.make(mainView, error.message ?: "SDK internal error", LENGTH_SHORT).show()
    }

    override fun onSuccessToRedirect(deepLinkCode: String) {
        Snackbar.make(mainView, "Sucesso: $deepLinkCode", LENGTH_SHORT).show()

    }
}