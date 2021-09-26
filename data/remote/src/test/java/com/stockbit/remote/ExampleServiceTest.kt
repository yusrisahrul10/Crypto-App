package com.stockbit.remote

import com.stockbit.remote.base.BaseTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

import retrofit2.HttpException

class ExampleServiceTest: BaseTest() {

    lateinit var fakeRemoteRepository: ExampleDataset
    @Before
    override fun setUp() {
        super.setUp()
        fakeRemoteRepository = ExampleDataset()

    }

    @Test
    fun getListCrypto() {
        val dataCrypto = fakeRemoteRepository.getListCrypto(1).blockingGet()

        assertNotNull(dataCrypto.Data)
        assertEquals(10, dataCrypto.Data.size)
    }
}