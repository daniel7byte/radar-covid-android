package com.indra.contacttracing.common.extensions

import com.google.gson.Gson

fun Any.toJson() = Gson().toJson(this)