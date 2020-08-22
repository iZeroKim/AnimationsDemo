package com.sriyank.animationsdemo

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {
    private var fadeAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun rotateAnimation(view: View) {
        rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }

    }

    fun scaleAnimation(view: View) {
        scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimation(view: View) {
        translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimation(view: View) {
        fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimator?.apply {
            setTarget(targetImage)
            addListener(this@MainActivity)
            start()
        }
    }

    //Listening to Animation Events
    override fun onAnimationStart(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "$p0 Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "$p0 Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "$p0 Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "$p0 Animation Started", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "$p0 Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "$p0 Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "$p0 Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "$p0 Animation Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "$p0 Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "$p0 Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "$p0 Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "$p0 Animation Cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationRepeat(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "$p0 Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "$p0 Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "$p0 Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "$p0 Animation Repeated", Toast.LENGTH_SHORT).show()
    }

}