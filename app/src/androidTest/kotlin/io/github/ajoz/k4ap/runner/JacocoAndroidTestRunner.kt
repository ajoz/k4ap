package io.github.ajoz.k4ap.runner

import android.os.Bundle
import android.support.test.runner.AndroidJUnitRunner
import android.util.Log

const val TAG = "JacocoAndroidTestRunner"

class JacocoAndroidTestRunner : AndroidJUnitRunner() {

    override fun finish(resultCode: Int, results: Bundle) {
        try {
            val rt = Class.forName("org.jacoco.agent.rt.RT")
            val getAgent = rt.getMethod("getAgent")
            val dump = getAgent.returnType.getMethod("dump", Boolean::class.javaPrimitiveType)
            val agent = getAgent.invoke(null)
            dump.invoke(agent, false)
        } catch (e: Throwable) {
            Log.e(TAG, Log.getStackTraceString(e))
        }

        super.finish(resultCode, results)
    }

    companion object {
        init {
            System.setProperty("jacoco-agent.destfile", "/sdcard/coverage.ec")
        }
    }
}