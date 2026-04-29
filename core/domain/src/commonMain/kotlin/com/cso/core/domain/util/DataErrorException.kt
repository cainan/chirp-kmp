package com.cso.core.domain.util

class DataErrorException(
    val error: DataError
) : Exception()