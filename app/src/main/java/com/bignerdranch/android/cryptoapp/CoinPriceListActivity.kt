package com.bignerdranch.android.cryptoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders.*
import com.bignerdranch.android.cryptoapp.adapters.CoinInfoAdapter
import com.bignerdranch.android.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_price_list.*

@Suppress("DEPRECATION")
class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity,coinPriceInfo.fromSymbol)
                startActivity(intent)
            }
        }
        rvCoinPriceList.adapter = adapter
        viewModel = of(this)[CoinViewModel::class.java]




        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })


    }


}






