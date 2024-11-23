package praonde.com.wheatherapp.home.domain.model

import praonde.com.wheatherapp.R

enum class Condition(val code: Int, val description: String, val resourceID: Int) {
    CONDITION_1(code = 1000, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_2(code = 1003, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_3(code = 1006, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_4(code = 1009, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_5(code = 1030, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_6(code = 1063, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_7(code = 1066, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_8(code = 1069, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_9(code = 1072, description = "Pune", resourceID = R.drawable.status_sunny),
    CONDITION_10(1087, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_11(1114, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_12(1117, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_13(1135, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_14(1147, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_15(1150, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_16(1153, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_17(1168, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_18(1171, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_19(1180, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_20(1183, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_21(1186, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_22(1189, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_23(1192, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_24(1195, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_25(1198, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_26(1201, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_27(1204, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_28(1207, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_29(1210, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_30(1213, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_31(1216, description = "Hyderabad", resourceID = R.drawable.status_cloudy),
    CONDITION_32(1219, description = "Hyderabad", resourceID = R.drawable.status_cloudy)
}