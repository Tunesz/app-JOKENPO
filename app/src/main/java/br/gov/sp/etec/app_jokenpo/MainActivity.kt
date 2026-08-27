package br.gov.sp.etec.app_jokenpo

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var text_resultado : TextView
    private lateinit var img_padrao : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        img_padrao = findViewById<ImageView> ( R.id.img_padrao)
        text_resultado = findViewById<TextView>( R.id.text_resultado)
        val pedra = findViewById<ImageView>( R.id.img_pedra)
        pedra.setOnClickListener {
            jogar("pedra")
        }

        val tesoura = findViewById<ImageView>(R.id.img_tesoura)
        tesoura.setOnClickListener {
            jogar("tesoura")
        }

        val papel = findViewById<ImageView>(R.id.img_papel)
        papel.setOnClickListener {
            jogar("papel")
        }



    }


    fun jogar(jogador : String){
        val opcoes =  arrayOf("papel", "tesoura", "pedra")
        val computador = opcoes[Random.nextInt(opcoes.size)]
        when(computador){
            "papel" -> img_padrao.setImageResource(R.drawable.papel)
            "pedra" -> img_padrao.setImageResource(R.drawable.pedra)
            "tesoura" -> img_padrao.setImageResource(R.drawable.tesoura)
        }
        when {
            (jogador == computador) -> {
                text_resultado.text = "Empate!"
            }

            (jogador == "pedra" && computador == "tesoura") -> {
                text_resultado.text = "voce venceu!"
            }

            (jogador == "papel" && computador == "pedra") -> {
                text_resultado.text = "voce venceu!"
            }

            (jogador == "tesoura" && computador == "papel") -> {
                text_resultado.text = "voce venceu!"
            }

            else -> {
                text_resultado.text = "Você perdeu"
            }
        }
    }
}