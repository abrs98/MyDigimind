package barrios.abrahan.mydigimind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ContrasenaActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrasena)

        mAuth = FirebaseAuth.getInstance();

        val btn_reestablecer: Button = findViewById(R.id.btn_restablecer)

        btn_reestablecer.setOnClickListener {
            val et_correo: EditText = findViewById(R.id.et_correo_cont)

            var correo: String = et_correo.text.toString()

            if(!correo.isNullOrBlank()){

                mAuth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener { task ->

                        if(task.isSuccessful){

                            Toast.makeText(this,"Correo Enviado Exitosamente",Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(this,"Error al enviar correo",Toast.LENGTH_SHORT).show()
                        }

                    }
            }else{
                Toast.makeText(this,"Ingresar Correo",Toast.LENGTH_SHORT).show()
            }
        }

    }
}