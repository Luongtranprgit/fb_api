package com.jwtsample.resttemplate.model;

public interface EventTypeEnum {
}

enum PurchaseTypeEnum {
    DATA_PACK,
    DATA_LOAN,
    MONETARY_STANDARD_L,
    OAN,
    MONETARY_AUTO_LOAN,
    SIM_TOP_UP,
    SIM_TOP_UP_WITH_DATA_,
    BONUS,
    SIM_TOP_UP_WITH_MONE,
    TARY_BONUS
}

enum PlanUpgradeTypeEnum {
    CARRIER_PLAN_PREPAID,
    CARRIER_PLAN_POSTPAID
}

enum PrepaidToPostpaidMigrationTypeEnum {
    CARRIER_PLAN_POSTPAID
}

enum EsimProfileInstalledTypeEnum {
    ESIM
}
enum EsimProfileNotInstalledTypeEnum {
    ESIM
}
enum EsimTrialConvertedToPaidTypeEnum {
    ESIM
}
enum EsimTrialFinishedTypeEnum {
    ESIM
}
