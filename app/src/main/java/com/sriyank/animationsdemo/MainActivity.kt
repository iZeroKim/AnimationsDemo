package com.sriyank.animationsdemo

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
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
            Toast.makeText(this, "ScaleAnimator Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "RotateAnimator Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "Translate Animation Started", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "Scale Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "Rotate Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "Translate Animation Ended", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "Fade Animation Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "Scale Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "Rotate Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "Translate Animation Cancelled", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "Fade Animation Cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationRepeat(p0: Animator?) {
        if (p0 == scaleAnimator)
            Toast.makeText(this, "Scale Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == rotateAnimator)
            Toast.makeText(this, "Rotate Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == translateAnimator)
            Toast.makeText(this, "Translate Animation Repeated", Toast.LENGTH_SHORT).show()
        if (p0 == fadeAnimator)
            Toast.makeText(this, "Fade Animation Repeated", Toast.LENGTH_SHORT).show()
    }

    fun setFromXML(view: View){
        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View){
        //Root Animator Set
        val rootSet = AnimatorSet()

        //Flip Animation
        val flip = ObjectAnimator.ofFloat(targetImage, "rotationX", 0.0f,360f)
        flip.duration = 500

        //Child Animator Set
        val childSet = AnimatorSet()

        //Scale animations
        val scaleX = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500

        val scaleY = ObjectAnimator.ofFloat(targetImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500

        rootSet.playSequentially(flip, childSet)
        childSet.playTogether(scaleX, scaleY)
        rootSet.start()
    }

}