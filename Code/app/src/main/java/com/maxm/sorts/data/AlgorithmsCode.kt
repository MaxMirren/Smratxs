package com.maxm.sorts.data


internal var sortsCode: HashMap<String, String> = hashMapOf(
    "Stupid sort" to
            "while (i < int_array.length) {<br>" +
            "&emsp;if (int_array[i] < int_array[i-1]) {<br>" +
            "&emsp;&emsp;temp = int_array[i - 1];<br>" +
            "&emsp;&emsp;int_array[i - 1] = int_array[i];<br>" +
            "&emsp;&emsp;int_array[i] = temp;<br>" +
            "&emsp;&emsp;i = 1;<br>" +
            "&emsp;}<br>" +
            "&emsp;else {<br>" +
            "&emsp;&emsp;i++;<br>" +
            "&emsp;}<br>" +
            "}",

    "Insertion sort" to
            "for(int i = 1; i < int_array.length; i++) {<br>" +
            "&emsp;for (int j = i; j > 0 && int_array[j - 1] > int_array[j]; j--) {<br>" + "... <br>}",

    "Bubble sort" to
            "int temp;<br>" +
            "for (int i = int_array.length - 1; i > 0; i--) {<br>" +
            "&emsp;for (int j = 0; j <= i; j++) {<br>" +
            "&emsp;&emsp;if (int_array[i-1] > int_array[i]) {<br>" +
            "&emsp;&emsp;&emsp;temp = int_array[i - 1];<br>" +
            "&emsp;&emsp;&emsp;int_array[i - 1] = int_array[i];<br>" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;}<br>" +
            "}",

    "Quick sort" to
            "private void quickSort (int start, int end) {<br>" +
            "&emsp;int i = start, j = end;<br>" +
            "&emsp;int stateElement = int_array[(i + j) / 2];<br>" +
            "&emsp;int temp;<br>" +
            "&emsp;while (i <= j) {<br>" +
            "&emsp;&emsp;while (int_array[i] < stateElement) {<br>" +
            "&emsp;&emsp;&emsp;i++;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;&emsp;while (int_array[j] > stateElement) {<br>" +
            "&emsp;&emsp;&emsp;j--;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;&emsp;if (i <= j) {<br>" +
            "&emsp;&emsp;&emsp;temp = int_array[i];<br>" +
            "&emsp;&emsp;&emsp;int_array[i] = int_array[j];<br>" +
            "&emsp;&emsp;&emsp;int_array[j] = temp;<br>" +
            "&emsp;&emsp;&emsp;i++;<br>" +
            "&emsp;&emsp;&emsp;j--;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;&emsp;String arrayText = \"Current array is: \";<br>" +
            "&emsp;&emsp;for (int integer : int_array) {<br>" +
            "&emsp;&emsp;&emsp;arrayText += integer + \" \";<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;}<br>" +
            "&emsp;if (start < j) {<br>" +
            "&emsp;&emsp;quickSort (start, j);<br>" +
            "&emsp;}<br>" +
            "&emsp;if (end > i) {<br>" +
            "&emsp;&emsp;quickSort (i, end);<br>" +
            "&emsp;}",

    "Cocktail Shaker sort"  to
            "int temp, left = 0, right = int_array.length - 1;<br>" +
            "while (left <= right) {<br>" +
            "&emsp;for (int i = left; i < right; i++) {<br>" +
            "&emsp;&emsp;if (int_array[i+1] < int_array[i]) {<br>" +
            "&emsp;&emsp;&emsp;temp = int_array[i + 1];<br>" +
            "&emsp;&emsp;&emsp;int_array[i + 1] = int_array[i];<br>" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;}<br>" +
            "&emsp;right--;<br>" +
            "&emsp;for (int j = right; j > left; j--) {<br>" +
            "&emsp;&emsp;if (int_array[j-1] > int_array[j]) {<br>" +
            "&emsp;&emsp;&emsp;temp = int_array[j - 1];<br>" +
            "&emsp;&emsp;&emsp;int_array[j - 1] = int_array[j];<br>" +
            "&emsp;&emsp;&emsp;int_array[j] = temp;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;}<br>" +
            "&emsp;left++;<br>" +
            "}",

    "Comb sort" to
            "final double DECREASE_FACTOR = 1.25;<br>" +
            "int temp, space = (int)(int_array.length/DECREASE_FACTOR);<br>" +
            "boolean noChanges = false;<br>" +
            "while (!noChanges && (space > 0)) {<br>" +
            "&emsp;noChanges = true;<br>" +
            "&emsp;for (int i = 0; i + space < int_array.length; i++) {<br>" +
            "&emsp;&emsp;if (int_array[i] > int_array[i+space]) {<br>" +
            "&emsp;&emsp;&emsp;temp = int_array[i + space];<br>" +
            "&emsp;&emsp;&emsp;int_array[i + space] = int_array[i];<br>" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;<br>" +
            "&emsp;&emsp;&emsp;noChanges = false;<br>" +
            "&emsp;&emsp;}<br>" +
            "&emsp;}<br>" +
            "&emsp;if (noChanges && (space > 1)) {<br>" +
            "&emsp;&emsp;noChanges = false;<br>" +
            "&emsp;}<br>" +
            "&emsp;space--;<br>" +
            "}"

)