package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var puntuacion: Int = 0
        var RadioGroup1 = findViewById<RadioGroup>(R.id.RG1)
        var RadioGroup2 = findViewById<RadioGroup>(R.id.RG2)
        var RadioGroup3 = findViewById<RadioGroup>(R.id.RG3)
        var RadioGroup4 = findViewById<RadioGroup>(R.id.RG4)
        var RadioGroup5 = findViewById<RadioGroup>(R.id.RG5)
        var RadioGroup6 = findViewById<RadioGroup>(R.id.RG6)
        var RadioGroup7 = findViewById<RadioGroup>(R.id.RG7)
        var RadioGroup8 = findViewById<RadioGroup>(R.id.RG8)
        var RadioGroup9 = findViewById<RadioGroup>(R.id.RG9)
        var RadioGroup10 = findViewById<RadioGroup>(R.id.RG10)
        var BtnEnviar = findViewById<Button>(R.id.button2)


        //var RadioGroup1 = findViewById<RadioGroup>(R.id.RG1)
        var RB11 = findViewById<RadioButton>(R.id.RB1_1)
        var RB12 = findViewById<RadioButton>(R.id.RB1_2)
        var RB13 = findViewById<RadioButton>(R.id.RB1_3)
        var RB14 = findViewById<RadioButton>(R.id.RB1_4)
        var RB15 = findViewById<RadioButton>(R.id.RB1_5)


        //var RadioGroup2 = findViewById<RadioGroup>(R.id.RG2)
        var RB21 = findViewById<RadioButton>(R.id.RB2_1)
        var RB22 = findViewById<RadioButton>(R.id.RB2_2)
        var RB23 = findViewById<RadioButton>(R.id.RB2_3)
        var RB24 = findViewById<RadioButton>(R.id.RB2_4)
        var RB25 = findViewById<RadioButton>(R.id.RB2_5)

        //var RadioGroup3 = findViewById<RadioGroup>(R.id.RG3)
        var RB31 = findViewById<RadioButton>(R.id.RB3_1)
        var RB32 = findViewById<RadioButton>(R.id.RB3_2)
        var RB33 = findViewById<RadioButton>(R.id.RB3_3)
        var RB34 = findViewById<RadioButton>(R.id.RB3_4)
        var RB35 = findViewById<RadioButton>(R.id.RB3_5)

        //var RadioGroup4 = findViewById<RadioGroup>(R.id.RG4)
        var RB41 = findViewById<RadioButton>(R.id.RB4_1)
        var RB42 = findViewById<RadioButton>(R.id.RB4_2)
        var RB43 = findViewById<RadioButton>(R.id.RB4_3)
        var RB44 = findViewById<RadioButton>(R.id.RB4_4)
        var RB45 = findViewById<RadioButton>(R.id.RB4_5)

        //var RadioGroup5 = findViewById<RadioGroup>(R.id.RG5)
        var RB51 = findViewById<RadioButton>(R.id.RB5_1)
        var RB52 = findViewById<RadioButton>(R.id.RB5_2)
        var RB53 = findViewById<RadioButton>(R.id.RB5_3)
        var RB54 = findViewById<RadioButton>(R.id.RB5_4)
        var RB55 = findViewById<RadioButton>(R.id.RB5_5)

        //var RadioGroup6 = findViewById<RadioGroup>(R.id.RG6)
        var RB61 = findViewById<RadioButton>(R.id.RB6_1)
        var RB62 = findViewById<RadioButton>(R.id.RB6_2)
        var RB63 = findViewById<RadioButton>(R.id.RB6_3)
        var RB64 = findViewById<RadioButton>(R.id.RB6_4)
        var RB65 = findViewById<RadioButton>(R.id.RB6_5)

        //var RadioGroup7 = findViewById<RadioGroup>(R.id.RG7)
        var RB71 = findViewById<RadioButton>(R.id.RB7_1)
        var RB72 = findViewById<RadioButton>(R.id.RB7_2)
        var RB73 = findViewById<RadioButton>(R.id.RB7_3)
        var RB74 = findViewById<RadioButton>(R.id.RB7_4)
        var RB75 = findViewById<RadioButton>(R.id.RB7_5)
        //var RadioGroup8 = findViewById<RadioGroup>(R.id.RG8)
        var RB81 = findViewById<RadioButton>(R.id.RB8_1)
        var RB82 = findViewById<RadioButton>(R.id.RB8_2)
        var RB83 = findViewById<RadioButton>(R.id.RB8_3)
        var RB84 = findViewById<RadioButton>(R.id.RB8_4)
        var RB85 = findViewById<RadioButton>(R.id.RB8_5)
        //var RadioGroup9 = findViewById<RadioGroup>(R.id.RG9)
        var RB91 = findViewById<RadioButton>(R.id.RB9_1)
        var RB92 = findViewById<RadioButton>(R.id.RB9_2)
        var RB93 = findViewById<RadioButton>(R.id.RB9_3)
        var RB94 = findViewById<RadioButton>(R.id.RB9_4)
        var RB95 = findViewById<RadioButton>(R.id.RB9_5)
        //var RadioGroup10 = findViewById<RadioGroup>(R.id.RG10)
        var RB101 = findViewById<RadioButton>(R.id.RB10_1)
        var RB102 = findViewById<RadioButton>(R.id.RB10_2)
        var RB103 = findViewById<RadioButton>(R.id.RB10_3)
        var RB104 = findViewById<RadioButton>(R.id.RB10_4)
        var RB105 = findViewById<RadioButton>(R.id.RB10_5)

        BtnEnviar.setOnClickListener {

            //Validar si algún RadioGroup no tiene RadioButton seleccionado
            var radioGroups = arrayOf(
                RadioGroup1,
                RadioGroup2,
                RadioGroup3,
                RadioGroup4,
                RadioGroup5,
                RadioGroup6,
                RadioGroup7,
                RadioGroup8,
                RadioGroup9,
                RadioGroup10
            )
            var allRadioButtonsSelected = true

            for (radioGroup in radioGroups) {
                if (radioGroup.checkedRadioButtonId == -1) {
                    allRadioButtonsSelected = false
                    break
                }
            }

            if (allRadioButtonsSelected) {
                //Calcular total de puntuación
                var RB11 = findViewById<RadioButton>(R.id.RB1_1)
                var RB12 = findViewById<RadioButton>(R.id.RB1_2)
                var RB13 = findViewById<RadioButton>(R.id.RB1_3)
                var RB14 = findViewById<RadioButton>(R.id.RB1_4)
                var RB15 = findViewById<RadioButton>(R.id.RB1_5)

                var RB21 = findViewById<RadioButton>(R.id.RB2_1)
                var RB22 = findViewById<RadioButton>(R.id.RB2_2)
                var RB23 = findViewById<RadioButton>(R.id.RB2_3)
                var RB24 = findViewById<RadioButton>(R.id.RB2_4)
                var RB25 = findViewById<RadioButton>(R.id.RB2_5)

                var RB31 = findViewById<RadioButton>(R.id.RB3_1)
                var RB32 = findViewById<RadioButton>(R.id.RB3_2)
                var RB33 = findViewById<RadioButton>(R.id.RB3_3)
                var RB34 = findViewById<RadioButton>(R.id.RB3_4)
                var RB35 = findViewById<RadioButton>(R.id.RB3_5)

                var RB41 = findViewById<RadioButton>(R.id.RB4_1)
                var RB42 = findViewById<RadioButton>(R.id.RB4_2)
                var RB43 = findViewById<RadioButton>(R.id.RB4_3)
                var RB44 = findViewById<RadioButton>(R.id.RB4_4)
                var RB45 = findViewById<RadioButton>(R.id.RB4_5)

                var RB51 = findViewById<RadioButton>(R.id.RB5_1)
                var RB52 = findViewById<RadioButton>(R.id.RB5_2)
                var RB53 = findViewById<RadioButton>(R.id.RB5_3)
                var RB54 = findViewById<RadioButton>(R.id.RB5_4)
                var RB55 = findViewById<RadioButton>(R.id.RB5_5)

                var RB61 = findViewById<RadioButton>(R.id.RB6_1)
                var RB62 = findViewById<RadioButton>(R.id.RB6_2)
                var RB63 = findViewById<RadioButton>(R.id.RB6_3)
                var RB64 = findViewById<RadioButton>(R.id.RB6_4)
                var RB65 = findViewById<RadioButton>(R.id.RB6_5)

                var RB71 = findViewById<RadioButton>(R.id.RB7_1)
                var RB72 = findViewById<RadioButton>(R.id.RB7_2)
                var RB73 = findViewById<RadioButton>(R.id.RB7_3)
                var RB74 = findViewById<RadioButton>(R.id.RB7_4)
                var RB75 = findViewById<RadioButton>(R.id.RB7_5)

                var RB81 = findViewById<RadioButton>(R.id.RB8_1)
                var RB82 = findViewById<RadioButton>(R.id.RB8_2)
                var RB83 = findViewById<RadioButton>(R.id.RB8_3)
                var RB84 = findViewById<RadioButton>(R.id.RB8_4)
                var RB85 = findViewById<RadioButton>(R.id.RB8_5)

                var RB91 = findViewById<RadioButton>(R.id.RB9_1)
                var RB92 = findViewById<RadioButton>(R.id.RB9_2)
                var RB93 = findViewById<RadioButton>(R.id.RB9_3)
                var RB94 = findViewById<RadioButton>(R.id.RB9_4)
                var RB95 = findViewById<RadioButton>(R.id.RB9_5)

                var RB101 = findViewById<RadioButton>(R.id.RB10_1)
                var RB102 = findViewById<RadioButton>(R.id.RB10_2)
                var RB103 = findViewById<RadioButton>(R.id.RB10_3)
                var RB104 = findViewById<RadioButton>(R.id.RB10_4)
                var RB105 = findViewById<RadioButton>(R.id.RB10_5)

                var puntuacion = 0

                if (RB11.isChecked) {
                    puntuacion += 1
                }
                if (RB12.isChecked) {
                    puntuacion += 2
                }
                if (RB13.isChecked) {
                    puntuacion += 3
                }
                if (RB14.isChecked) {
                    puntuacion += 4
                }
                if (RB15.isChecked) {
                    puntuacion += 5
                }

                if (RB21.isChecked) {
                    puntuacion += 1
                }
                if (RB22.isChecked) {
                    puntuacion += 2
                }
                if (RB23.isChecked) {
                    puntuacion += 3
                }
                if (RB24.isChecked) {
                    puntuacion += 4
                }
                if (RB25.isChecked) {
                    puntuacion += 5
                }

                if (RB31.isChecked) {
                    puntuacion += 1
                }
                if (RB32.isChecked) {
                    puntuacion += 2
                }
                if (RB33.isChecked) {
                    puntuacion += 3
                }
                if (RB34.isChecked) {
                    puntuacion += 4

                }
                if (RB35.isChecked) {
                    puntuacion += 5
                }

                if (RB41.isChecked) {
                    puntuacion += 1
                }
                if (RB42.isChecked) {
                    puntuacion += 2
                }
                if (RB43.isChecked) {
                    puntuacion += 3
                }
                if (RB44.isChecked) {
                    puntuacion += 4
                }
                if (RB45.isChecked) {
                    puntuacion += 5
                }
                if (RB51.isChecked) {
                    puntuacion += 1
                }
                if (RB52.isChecked) {
                    puntuacion += 2
                }
                if (RB53.isChecked) {
                    puntuacion += 3
                }
                if (RB54.isChecked) {
                    puntuacion += 4
                }
                if (RB55.isChecked) {
                    puntuacion += 5
                }

                if (RB61.isChecked) {
                    puntuacion += 1
                }
                if (RB62.isChecked) {
                    puntuacion += 2
                }
                if (RB63.isChecked) {
                    puntuacion += 3
                }
                if (RB64.isChecked) {
                    puntuacion += 4
                }
                if (RB65.isChecked) {
                    puntuacion += 5
                }

                if (RB71.isChecked) {
                    puntuacion += 1
                }
                if (RB72.isChecked) {
                    puntuacion += 2
                }
                if (RB73.isChecked) {
                    puntuacion += 3
                }
                if (RB74.isChecked) {
                    puntuacion += 4
                }
                if (RB75.isChecked) {
                    puntuacion += 5
                }

                if (RB81.isChecked) {
                    puntuacion += 1
                }
                if (RB82.isChecked) {
                    puntuacion += 2
                }
                if (RB83.isChecked) {
                    puntuacion += 3
                }
                if (RB84.isChecked) {
                    puntuacion += 4
                }
                if (RB85.isChecked) {
                    puntuacion += 5
                }

                if (RB91.isChecked) {
                    puntuacion += 1
                }
                if (RB92.isChecked) {
                    puntuacion += 2
                }
                if (RB93.isChecked) {
                    puntuacion += 3
                }
                if (RB94.isChecked) {
                    puntuacion += 4
                }
                if (RB95.isChecked) {
                    puntuacion += 5
                }
                if (RB101.isChecked) {
                    puntuacion += 1
                }
                if (RB102.isChecked) {
                    puntuacion += 2
                }
                if (RB103.isChecked) {
                    puntuacion += 3
                }
                if (RB104.isChecked) {
                    puntuacion += 4
                }
                if (RB105.isChecked) {
                    puntuacion += 5
                }

                val intent = Intent(this, ResultadosTest::class.java)
                if (puntuacion >= 32) {
                    intent.putExtra("mensaje", "Tienes una buena conexión emocional con los demás y manejas tus emociones de manera saludable.")
                } else if (puntuacion >= 21 && puntuacion < 32) {
                    intent.putExtra("mensaje", "Tienes una conexión emocional moderada con los demás, pero podrías mejorar en algunos aspectos del manejo de tus emociones.")
                } else {
                    intent.putExtra("mensaje", "Tienes dificultades en la conexión emocional con los demás y el manejo de tus emociones. Se recomienda buscar apoyo profesional.")
                }
                startActivity(intent)

            } else {
                Toast.makeText(this, "Debe seleccionar una opción en cada pregunta", Toast.LENGTH_SHORT).show()
            }

        }

    }
}