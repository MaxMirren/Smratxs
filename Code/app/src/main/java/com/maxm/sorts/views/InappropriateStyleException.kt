package com.maxm.sorts.views

import java.lang.Exception

class InappropriateStyleException(message: String =
                                      "Before using FontFlexTextView as line numbering set its style to " +
                                              "\"SortsTextViewCodeNumbering\""): Exception(message)