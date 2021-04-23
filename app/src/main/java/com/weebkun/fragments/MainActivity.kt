package com.weebkun.fragments

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), ButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alternate)

    }

    var sum = 0

    override fun onButtonClick(number: Int) {
        var old = sum
        sum += number
        //Toast.makeText(this, "adding $number to $old gives you $sum", Toast.LENGTH_LONG).show()
        AlertFragment.newInstance("adding $number to $old gives you $sum").show(supportFragmentManager, "dialog")
    }

    /**
     * loads fragment A
     */
    fun runFragmentA(v: View) {
        var fragment = DemoA.newInstance()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment, "fragA")
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /**
     * loads fragment B
     */
    fun runFragmentB(v: View) {
        var fragment = DemoB.newInstance()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment, "fragB")
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun toggle(v: View) {
        var fragment = supportFragmentManager.findFragmentByTag("fragA")
        if(fragment != null && fragment is DemoA) fragment.toggleSumVisibility()
        else Toast.makeText(this, "fragment is null or not of type fragment A", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("close")
            .setMessage("are you sure?")
            .setPositiveButton("yes") { dialog, which ->
                finish()
            }
            .setNegativeButton("cancel") {dialog, which ->
                dialog.cancel()
            }.show()

        return super.onOptionsItemSelected(item)
    }
}