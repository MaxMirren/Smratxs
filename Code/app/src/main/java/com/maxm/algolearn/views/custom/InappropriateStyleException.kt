package com.maxm.algolearn.views.custom

import java.lang.Exception

class InappropriateStyleException(message: String =
                                      "Before using FontFlexTextView as line numbering set its style to " +
                                              "\"SortsTextViewCodeNumbering\""): Exception(message)