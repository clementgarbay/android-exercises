package fr.android.androidexercises

import android.app.IntentService
import android.content.Intent
import android.widget.Toast

class JobService : IntentService("JobService") {

    override fun onHandleIntent(intent: Intent?) {
        val endTime = System.currentTimeMillis() + 5 * 1000

        try {
            java.lang.Object().wait(endTime - System.currentTimeMillis())
        } catch (ignored: Exception) {

        }

        Toast.makeText(this, "It's finish", Toast.LENGTH_SHORT).show()
    }

}