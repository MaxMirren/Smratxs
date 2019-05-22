package com.maxm.algolearn

import android.content.Context
import android.net.IpSecManager
import com.maxm.algolearn.models.AlgorithmsListCreator
import com.maxm.algolearn.models.sortsCode
import com.maxm.algolearn.utils.TextColorizer
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AlgorithmsInit {

    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun initAlgorithmsList_ResourcesFound() {
        var checkIsSuccessful = false
        try {
            val namesArray = instrumentationContext.resources.getStringArray(R.array.sorts_names)
            val descriptionArray = instrumentationContext.resources.getStringArray(R.array.sorts_description)
            val characteristicsArray = instrumentationContext.resources.getStringArray(R.array.sorts_description)
            val demosArray = instrumentationContext.resources.getStringArray(R.array.sorts_description)
            val debuggerArray = instrumentationContext.resources.getStringArray(R.array.sorts_debugs)
            checkIsSuccessful = if (allArraysAreWithProperCount(namesArray,
                    arrayListOf(descriptionArray, characteristicsArray, demosArray, debuggerArray))) {
                AlgorithmsListCreator(namesArray, descriptionArray, characteristicsArray, demosArray, debuggerArray)
                for (key in sortsCode.keys) {
                    sortsCode[key] = TextColorizer(sortsCode.getValue(key)).getColorizedText()
                }
                true
            } else false

        } catch (e: IpSecManager.ResourceUnavailableException) {
            System.err.println("ResourceUnavailableException: ${e.message.toString()}")
        }
        if (!checkIsSuccessful) throw ExceptionInInitializerError()
        Assert.assertEquals(checkIsSuccessful, true)
    }


    private fun allArraysAreWithProperCount(namesArray: Array<String>, restData: ArrayList<Array<String>>): Boolean {
        val firstRestDataElementSize = restData[0].size
        if (namesArray.size >= firstRestDataElementSize) {
            for (index in 1 until restData.size) {
                if (restData[0].size != restData[index].size) {
                    return false
                }
            }
        }
        return true
    }
}