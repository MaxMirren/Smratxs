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
            "for(int i = 1; i < int_array.length; i++) {\n" +
            "&emsp;for (int j = i; j > 0 && int_array[j - 1] > int_array[j]; j--) {\n" + "... \n}",

    "Bubble sort" to
            "int temp;\n" +
            "for (int i = int_array.length - 1; i > 0; i--) {\n" +
            "&emsp;for (int j = 0; j <= i; j++) {\n" +
            "&emsp;&emsp;if (int_array[i-1] > int_array[i]) {\n" +
            "&emsp;&emsp;&emsp;temp = int_array[i - 1];\n" +
            "&emsp;&emsp;&emsp;int_array[i - 1] = int_array[i];\n" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;}\n" +
            "}",

    "Quick sort" to
            "private void quickSort (int start, int end) {\n" +
            "&emsp;int i = start, j = end;\n" +
            "&emsp;int stateElement = int_array[(i + j) / 2];\n" +
            "&emsp;int temp;\n" +
            "&emsp;while (i <= j) {\n" +
            "&emsp;&emsp;while (int_array[i] < stateElement) {\n" +
            "&emsp;&emsp;&emsp;i++;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;&emsp;while (int_array[j] > stateElement) {\n" +
            "&emsp;&emsp;&emsp;j--;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;&emsp;if (i <= j) {\n" +
            "&emsp;&emsp;&emsp;temp = int_array[i];\n" +
            "&emsp;&emsp;&emsp;int_array[i] = int_array[j];\n" +
            "&emsp;&emsp;&emsp;int_array[j] = temp;\n" +
            "&emsp;&emsp;&emsp;i++;\n" +
            "&emsp;&emsp;&emsp;j--;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;&emsp;String arrayText = \"Current array is: \";\n" +
            "&emsp;&emsp;for (int integer : int_array) {\n" +
            "&emsp;&emsp;&emsp;arrayText += integer + \" \";\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;}\n" +
            "&emsp;if (start < j) {\n" +
            "&emsp;&emsp;quickSort (start, j);\n" +
            "&emsp;}\n" +
            "&emsp;if (end > i) {\n" +
            "&emsp;&emsp;quickSort (i, end);\n" +
            "&emsp;}",

    "Cocktail Shaker sort"  to
            "int temp, left = 0, right = int_array.length - 1;\n" +
            "while (left <= right) {\n" +
            "&emsp;for (int i = left; i < right; i++) {\n" +
            "&emsp;&emsp;if (int_array[i+1] < int_array[i]) {\n" +
            "&emsp;&emsp;&emsp;temp = int_array[i + 1];\n" +
            "&emsp;&emsp;&emsp;int_array[i + 1] = int_array[i];\n" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;}\n" +
            "&emsp;right--;\n" +
            "&emsp;for (int j = right; j > left; j--) {\n" +
            "&emsp;&emsp;if (int_array[j-1] > int_array[j]) {\n" +
            "&emsp;&emsp;&emsp;temp = int_array[j - 1];\n" +
            "&emsp;&emsp;&emsp;int_array[j - 1] = int_array[j];\n" +
            "&emsp;&emsp;&emsp;int_array[j] = temp;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;}\n" +
            "&emsp;left++;\n" +
            "}",

    "Comb sort" to
            "final double DECREASE_FACTOR = 1.25;\n" +
            "int temp, space = (int)(int_array.length/DECREASE_FACTOR);\n" +
            "boolean noChanges = false;\n" +
            "while (!noChanges && (space > 0)) {\n" +
            "&emsp;noChanges = true;\n" +
            "&emsp;for (int i = 0; i + space < int_array.length; i++) {\n" +
            "&emsp;&emsp;if (int_array[i] > int_array[i+space]) {\n" +
            "&emsp;&emsp;&emsp;temp = int_array[i + space];\n" +
            "&emsp;&emsp;&emsp;int_array[i + space] = int_array[i];\n" +
            "&emsp;&emsp;&emsp;int_array[i] = temp;\n" +
            "&emsp;&emsp;&emsp;noChanges = false;\n" +
            "&emsp;&emsp;}\n" +
            "&emsp;}\n" +
            "&emsp;if (noChanges && (space > 1)) {\n" +
            "&emsp;&emsp;noChanges = false;\n" +
            "&emsp;}\n" +
            "&emsp;space--;\n" +
            "}"

)