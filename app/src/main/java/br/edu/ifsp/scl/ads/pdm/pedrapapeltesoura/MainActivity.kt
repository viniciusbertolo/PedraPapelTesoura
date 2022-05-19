package br.edu.ifsp.scl.ads.pdm.pedrapapeltesoura


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.ifsp.scl.ads.pdm.pedrapapeltesoura.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding


    private lateinit var settingsActivityLauncher: ActivityResultLauncher<Intent>

    private lateinit var geradorRandomico: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        geradorRandomico = Random(System.currentTimeMillis())

        //usuario escolhe pedra
        activityMainBinding.pedraIv.setOnClickListener {

            //jogada humano
            activityMainBinding.jogadaHumanoIv.setImageResource(
                resources.getIdentifier("icon_2", "drawable", packageName)
            )
            //jogada cp 1
            val resultado: Int = geradorRandomico.nextInt(1..3)
            activityMainBinding.jogadaComputador1Iv.setImageResource(
                resources.getIdentifier("icon_$resultado", "drawable", packageName)
            )
            //cp2 desativado
            activityMainBinding.jogadaComputador2Iv.setImageResource(
                resources.getIdentifier("x", "drawable", packageName)
            )

            //vencedor
            when (resultado) {
                2 -> {
                    activityMainBinding.vencedorTv.text = "Empate"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("riso", "drawable", packageName)
                    )
                }

                1 -> {
                    activityMainBinding.vencedorTv.text = "You Lose"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("loser", "drawable", packageName)
                    )
                }
                3 -> {
                    activityMainBinding.vencedorTv.text = "You Win"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("win", "drawable", packageName)
                    )
                }


            }


        }

        //usuario escolhe papel
        activityMainBinding.papelIv.setOnClickListener {

            activityMainBinding.jogadaHumanoIv.setImageResource(
                resources.getIdentifier("icon_1", "drawable", packageName)
            )

            val resultado: Int = geradorRandomico.nextInt(1..3)
            activityMainBinding.jogadaComputador1Iv.setImageResource(
                resources.getIdentifier("icon_$resultado", "drawable", packageName)
            )

            activityMainBinding.jogadaComputador2Iv.setImageResource(
                resources.getIdentifier("x", "drawable", packageName)
            )

            //vencedor
            when (resultado) {
                1 -> {
                    activityMainBinding.vencedorTv.text = "Empate"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("riso", "drawable", packageName)
                    )
                }

                3 -> {
                    activityMainBinding.vencedorTv.text = "You Lose"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("loser", "drawable", packageName)
                    )
                }
                2 -> {
                    activityMainBinding.vencedorTv.text = "You Win"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("win", "drawable", packageName)
                    )
                }


            }


        }

        //usuario escolhe tesoura
        activityMainBinding.tesouraIv.setOnClickListener {

            activityMainBinding.jogadaHumanoIv.setImageResource(
                resources.getIdentifier("icon_3", "drawable", packageName)
            )

            val resultado: Int = geradorRandomico.nextInt(1..3)
            activityMainBinding.jogadaComputador1Iv.setImageResource(
                resources.getIdentifier("icon_$resultado", "drawable", packageName)
            )

            activityMainBinding.jogadaComputador2Iv.setImageResource(
                resources.getIdentifier("x", "drawable", packageName)
            )

            //vencedor
            when (resultado) {
                3 -> {
                    activityMainBinding.vencedorTv.text = "Empate"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("riso", "drawable", packageName)
                    )
                }

                2 -> {
                    activityMainBinding.vencedorTv.text = "You Lose"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("loser", "drawable", packageName)
                    )
                }
                1 -> {
                    activityMainBinding.vencedorTv.text = "You Win"
                    activityMainBinding.vencedorIv.setImageResource(
                        resources.getIdentifier("win", "drawable", packageName)
                    )
                }


            }


        }


        settingsActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {

                    if (result.data != null) {
                        val configuracao: Configuracao? =
                            result.data?.getParcelableExtra(Intent.EXTRA_USER)


                        if (configuracao != null) {
                            if (configuracao.numeroJogadores == 2) {

                                //usuario escolhe pedra
                                activityMainBinding.pedraIv.setOnClickListener {

                                    //jogada humano
                                    activityMainBinding.jogadaHumanoIv.setImageResource(
                                        resources.getIdentifier("icon_2", "drawable", packageName)
                                    )
                                    //jogada cp 1
                                    val resultado: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador1Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                    //cp2 desativado
                                    activityMainBinding.jogadaComputador2Iv.setImageResource(
                                        resources.getIdentifier("x", "drawable", packageName)
                                    )

                                    //vencedor
                                    when (resultado) {
                                        2 -> {
                                            activityMainBinding.vencedorTv.text = "Empate"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "riso",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }

                                        1 -> {
                                            activityMainBinding.vencedorTv.text = "You Lose"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "loser",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }
                                        3 -> {
                                            activityMainBinding.vencedorTv.text = "You Win"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "win",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }


                                    }


                                }

                                //usuario escolhe papel
                                activityMainBinding.papelIv.setOnClickListener {

                                    activityMainBinding.jogadaHumanoIv.setImageResource(
                                        resources.getIdentifier("icon_1", "drawable", packageName)
                                    )

                                    val resultado: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador1Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )

                                    activityMainBinding.jogadaComputador2Iv.setImageResource(
                                        resources.getIdentifier("x", "drawable", packageName)
                                    )

                                    //vencedor
                                    when (resultado) {
                                        1 -> {
                                            activityMainBinding.vencedorTv.text = "Empate"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "riso",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }

                                        3 -> {
                                            activityMainBinding.vencedorTv.text = "You Lose"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "loser",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }
                                        2 -> {
                                            activityMainBinding.vencedorTv.text = "You Win"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "win",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }


                                    }


                                }

                                //usuario escolhe tesoura
                                activityMainBinding.tesouraIv.setOnClickListener {

                                    activityMainBinding.jogadaHumanoIv.setImageResource(
                                        resources.getIdentifier("icon_3", "drawable", packageName)
                                    )

                                    val resultado: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador1Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )

                                    activityMainBinding.jogadaComputador2Iv.setImageResource(
                                        resources.getIdentifier("x", "drawable", packageName)
                                    )

                                    //vencedor
                                    when (resultado) {
                                        3 -> {
                                            activityMainBinding.vencedorTv.text = "Empate"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "riso",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }

                                        2 -> {
                                            activityMainBinding.vencedorTv.text = "You Lose"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "loser",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }
                                        1 -> {
                                            activityMainBinding.vencedorTv.text = "You Win"
                                            activityMainBinding.vencedorIv.setImageResource(
                                                resources.getIdentifier(
                                                    "win",
                                                    "drawable",
                                                    packageName
                                                )
                                            )
                                        }


                                    }


                                }


                            } else if (configuracao.numeroJogadores == 3) {

                                //usuario escolhe pedra
                                activityMainBinding.pedraIv.setOnClickListener {

                                    //jogada humano
                                    activityMainBinding.jogadaHumanoIv.setImageResource(
                                        resources.getIdentifier("icon_2", "drawable", packageName)
                                    )
                                    //jogada cp 1
                                    val resultado: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador1Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                    //jogada cp2
                                    val resultado2: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador2Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )


                                    //vencedor
                                    if (resultado == 2 && resultado2 == 2 ||
                                        resultado == 1 && resultado2 == 3 ||
                                        resultado == 3 && resultado2 == 1 ||
                                        resultado == 1 && resultado2 == 1 ||
                                        resultado == 2 && resultado2 == 3 ||
                                        resultado == 3 && resultado2 == 2
                                    ) {
                                        activityMainBinding.vencedorTv.text = "Empate"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier("riso", "drawable", packageName)
                                        )
                                    } else if (resultado == 3 && resultado2 == 3) {
                                        activityMainBinding.vencedorTv.text = "You Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier("win", "drawable", packageName)
                                        )
                                    } else if (resultado == 2 && resultado2 == 1) {

                                        activityMainBinding.vencedorTv.text = "You Lose - Sys2 Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "loser",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    } else if (resultado == 1 && resultado2 == 2) {

                                        activityMainBinding.vencedorTv.text = "You Lose - Sys1 Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "loser",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    } else {

                                        activityMainBinding.vencedorTv.text = "Error"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "vazio",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    }


                                }

                                //usuario escolhe papel
                                activityMainBinding.papelIv.setOnClickListener {

                                    activityMainBinding.jogadaHumanoIv.setImageResource(
                                        resources.getIdentifier("icon_1", "drawable", packageName)
                                    )

                                    //jogada cp 1
                                    val resultado: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador1Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                    //jogada cp2
                                    val resultado2: Int = geradorRandomico.nextInt(1..3)
                                    activityMainBinding.jogadaComputador2Iv.setImageResource(
                                        resources.getIdentifier(
                                            "icon_$resultado",
                                            "drawable",
                                            packageName
                                        )
                                    )


                                    //vencedor
                                    if (resultado == 1 && resultado2 == 1 ||
                                        resultado == 1 && resultado2 == 2 ||
                                        resultado == 2 && resultado2 == 1 ||
                                        resultado == 3 && resultado2 == 2 ||
                                        resultado == 2 && resultado2 == 3 ||
                                        resultado == 3 && resultado2 == 3
                                    ) {
                                        activityMainBinding.vencedorTv.text = "Empate"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier("riso", "drawable", packageName)
                                        )
                                    } else if (resultado == 2 && resultado2 == 2) {
                                        activityMainBinding.vencedorTv.text = "You Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier("win", "drawable", packageName)
                                        )
                                    } else if (resultado == 1 && resultado2 == 3) {

                                        activityMainBinding.vencedorTv.text = "You Lose - Sys2 Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "loser",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    } else if (resultado == 3 && resultado2 == 1) {

                                        activityMainBinding.vencedorTv.text = "You Lose - Sys1 Win"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "loser",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    } else {

                                        activityMainBinding.vencedorTv.text = "Error"
                                        activityMainBinding.vencedorIv.setImageResource(
                                            resources.getIdentifier(
                                                "vazio",
                                                "drawable",
                                                packageName
                                            )
                                        )
                                    }

                                }


                            }

                            //usuario escolhe tesoura
                            activityMainBinding.tesouraIv.setOnClickListener {

                                activityMainBinding.jogadaHumanoIv.setImageResource(
                                    resources.getIdentifier("icon_3", "drawable", packageName)
                                )

                                //jogada cp 1
                                val resultado: Int = geradorRandomico.nextInt(1..3)
                                activityMainBinding.jogadaComputador1Iv.setImageResource(
                                    resources.getIdentifier(
                                        "icon_$resultado",
                                        "drawable",
                                        packageName
                                    )
                                )
                                //jogada cp2
                                val resultado2: Int = geradorRandomico.nextInt(1..3)
                                activityMainBinding.jogadaComputador2Iv.setImageResource(
                                    resources.getIdentifier(
                                        "icon_$resultado",
                                        "drawable",
                                        packageName
                                    )
                                )


                                //vencedor
                                if (resultado == 3 && resultado2 == 3 ||
                                    resultado == 2 && resultado2 == 1 ||
                                    resultado == 1 && resultado2 == 2 ||
                                    resultado == 3 && resultado2 == 1 ||
                                    resultado == 1 && resultado2 == 3 ||
                                    resultado == 2 && resultado2 == 2
                                ) {
                                    activityMainBinding.vencedorTv.text = "Empate"
                                    activityMainBinding.vencedorIv.setImageResource(
                                        resources.getIdentifier("riso", "drawable", packageName)
                                    )
                                } else if (resultado == 1 && resultado2 == 1) {
                                    activityMainBinding.vencedorTv.text = "You Win"
                                    activityMainBinding.vencedorIv.setImageResource(
                                        resources.getIdentifier("win", "drawable", packageName)
                                    )
                                } else if (resultado == 3 && resultado2 == 1) {

                                    activityMainBinding.vencedorTv.text = "You Lose - Sys2 Win"
                                    activityMainBinding.vencedorIv.setImageResource(
                                        resources.getIdentifier(
                                            "loser",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                } else if (resultado == 3 && resultado2 == 2) {

                                    activityMainBinding.vencedorTv.text = "You Lose - Sys1 Win"
                                    activityMainBinding.vencedorIv.setImageResource(
                                        resources.getIdentifier(
                                            "loser",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                } else {

                                    activityMainBinding.vencedorTv.text = "Error"
                                    activityMainBinding.vencedorIv.setImageResource(
                                        resources.getIdentifier(
                                            "vazio",
                                            "drawable",
                                            packageName
                                        )
                                    )
                                }

                            }


                        }


                            }


                        }
                    }
                }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.settingsMi){
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            settingsActivityLauncher.launch(settingsIntent)
            return true
        }
        return false
    }
}
