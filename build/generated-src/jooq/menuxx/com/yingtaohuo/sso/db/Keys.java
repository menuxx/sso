/*
 * This file is generated by jOOQ.
*/
package com.yingtaohuo.sso.db;


import com.yingtaohuo.sso.db.tables.TActivity;
import com.yingtaohuo.sso.db.tables.TActivityMinus;
import com.yingtaohuo.sso.db.tables.TActivityNewuser;
import com.yingtaohuo.sso.db.tables.TAddress;
import com.yingtaohuo.sso.db.tables.TBankAccount;
import com.yingtaohuo.sso.db.tables.TCategory;
import com.yingtaohuo.sso.db.tables.TChargeApply;
import com.yingtaohuo.sso.db.tables.TConfig;
import com.yingtaohuo.sso.db.tables.TCorp;
import com.yingtaohuo.sso.db.tables.TCorpCollect;
import com.yingtaohuo.sso.db.tables.TCorpDiscover;
import com.yingtaohuo.sso.db.tables.TCorpFeedback;
import com.yingtaohuo.sso.db.tables.TCorpTotal;
import com.yingtaohuo.sso.db.tables.TCorpUser;
import com.yingtaohuo.sso.db.tables.TCorpUserRole;
import com.yingtaohuo.sso.db.tables.TDadaMerchant;
import com.yingtaohuo.sso.db.tables.TDeliveryShop;
import com.yingtaohuo.sso.db.tables.TDeliveryTransport;
import com.yingtaohuo.sso.db.tables.TFeieprinter;
import com.yingtaohuo.sso.db.tables.TFormat;
import com.yingtaohuo.sso.db.tables.TItem;
import com.yingtaohuo.sso.db.tables.TOrder;
import com.yingtaohuo.sso.db.tables.TOrderItem;
import com.yingtaohuo.sso.db.tables.TPrinter;
import com.yingtaohuo.sso.db.tables.TRechargeRecord;
import com.yingtaohuo.sso.db.tables.TScene;
import com.yingtaohuo.sso.db.tables.TShopChargeRecord;
import com.yingtaohuo.sso.db.tables.TShopChargeRecordBalance;
import com.yingtaohuo.sso.db.tables.TTable;
import com.yingtaohuo.sso.db.tables.TTaste;
import com.yingtaohuo.sso.db.tables.TTopup;
import com.yingtaohuo.sso.db.tables.TUser;
import com.yingtaohuo.sso.db.tables.TUserBalance;
import com.yingtaohuo.sso.db.tables.records.TActivityMinusRecord;
import com.yingtaohuo.sso.db.tables.records.TActivityNewuserRecord;
import com.yingtaohuo.sso.db.tables.records.TActivityRecord;
import com.yingtaohuo.sso.db.tables.records.TAddressRecord;
import com.yingtaohuo.sso.db.tables.records.TBankAccountRecord;
import com.yingtaohuo.sso.db.tables.records.TCategoryRecord;
import com.yingtaohuo.sso.db.tables.records.TChargeApplyRecord;
import com.yingtaohuo.sso.db.tables.records.TConfigRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpCollectRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpDiscoverRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpFeedbackRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpTotalRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpUserRecord;
import com.yingtaohuo.sso.db.tables.records.TCorpUserRoleRecord;
import com.yingtaohuo.sso.db.tables.records.TDadaMerchantRecord;
import com.yingtaohuo.sso.db.tables.records.TDeliveryShopRecord;
import com.yingtaohuo.sso.db.tables.records.TDeliveryTransportRecord;
import com.yingtaohuo.sso.db.tables.records.TFeieprinterRecord;
import com.yingtaohuo.sso.db.tables.records.TFormatRecord;
import com.yingtaohuo.sso.db.tables.records.TItemRecord;
import com.yingtaohuo.sso.db.tables.records.TOrderItemRecord;
import com.yingtaohuo.sso.db.tables.records.TOrderRecord;
import com.yingtaohuo.sso.db.tables.records.TPrinterRecord;
import com.yingtaohuo.sso.db.tables.records.TRechargeRecordRecord;
import com.yingtaohuo.sso.db.tables.records.TSceneRecord;
import com.yingtaohuo.sso.db.tables.records.TShopChargeRecordBalanceRecord;
import com.yingtaohuo.sso.db.tables.records.TShopChargeRecordRecord;
import com.yingtaohuo.sso.db.tables.records.TTableRecord;
import com.yingtaohuo.sso.db.tables.records.TTasteRecord;
import com.yingtaohuo.sso.db.tables.records.TTopupRecord;
import com.yingtaohuo.sso.db.tables.records.TUserBalanceRecord;
import com.yingtaohuo.sso.db.tables.records.TUserRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;
import org.jooq.types.UInteger;


/**
 * A class modelling foreign key relationships between tables of the <code>menuxx</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<TActivityRecord, UInteger> IDENTITY_T_ACTIVITY = Identities0.IDENTITY_T_ACTIVITY;
    public static final Identity<TActivityMinusRecord, UInteger> IDENTITY_T_ACTIVITY_MINUS = Identities0.IDENTITY_T_ACTIVITY_MINUS;
    public static final Identity<TActivityNewuserRecord, UInteger> IDENTITY_T_ACTIVITY_NEWUSER = Identities0.IDENTITY_T_ACTIVITY_NEWUSER;
    public static final Identity<TAddressRecord, UInteger> IDENTITY_T_ADDRESS = Identities0.IDENTITY_T_ADDRESS;
    public static final Identity<TBankAccountRecord, UInteger> IDENTITY_T_BANK_ACCOUNT = Identities0.IDENTITY_T_BANK_ACCOUNT;
    public static final Identity<TCategoryRecord, Integer> IDENTITY_T_CATEGORY = Identities0.IDENTITY_T_CATEGORY;
    public static final Identity<TChargeApplyRecord, Integer> IDENTITY_T_CHARGE_APPLY = Identities0.IDENTITY_T_CHARGE_APPLY;
    public static final Identity<TConfigRecord, UInteger> IDENTITY_T_CONFIG = Identities0.IDENTITY_T_CONFIG;
    public static final Identity<TCorpRecord, UInteger> IDENTITY_T_CORP = Identities0.IDENTITY_T_CORP;
    public static final Identity<TCorpCollectRecord, Integer> IDENTITY_T_CORP_COLLECT = Identities0.IDENTITY_T_CORP_COLLECT;
    public static final Identity<TCorpDiscoverRecord, Integer> IDENTITY_T_CORP_DISCOVER = Identities0.IDENTITY_T_CORP_DISCOVER;
    public static final Identity<TCorpFeedbackRecord, Integer> IDENTITY_T_CORP_FEEDBACK = Identities0.IDENTITY_T_CORP_FEEDBACK;
    public static final Identity<TCorpTotalRecord, Integer> IDENTITY_T_CORP_TOTAL = Identities0.IDENTITY_T_CORP_TOTAL;
    public static final Identity<TCorpUserRecord, Integer> IDENTITY_T_CORP_USER = Identities0.IDENTITY_T_CORP_USER;
    public static final Identity<TCorpUserRoleRecord, UInteger> IDENTITY_T_CORP_USER_ROLE = Identities0.IDENTITY_T_CORP_USER_ROLE;
    public static final Identity<TDadaMerchantRecord, UInteger> IDENTITY_T_DADA_MERCHANT = Identities0.IDENTITY_T_DADA_MERCHANT;
    public static final Identity<TDeliveryShopRecord, UInteger> IDENTITY_T_DELIVERY_SHOP = Identities0.IDENTITY_T_DELIVERY_SHOP;
    public static final Identity<TDeliveryTransportRecord, UInteger> IDENTITY_T_DELIVERY_TRANSPORT = Identities0.IDENTITY_T_DELIVERY_TRANSPORT;
    public static final Identity<TFeieprinterRecord, UInteger> IDENTITY_T_FEIEPRINTER = Identities0.IDENTITY_T_FEIEPRINTER;
    public static final Identity<TFormatRecord, UInteger> IDENTITY_T_FORMAT = Identities0.IDENTITY_T_FORMAT;
    public static final Identity<TItemRecord, Integer> IDENTITY_T_ITEM = Identities0.IDENTITY_T_ITEM;
    public static final Identity<TOrderRecord, Integer> IDENTITY_T_ORDER = Identities0.IDENTITY_T_ORDER;
    public static final Identity<TOrderItemRecord, Integer> IDENTITY_T_ORDER_ITEM = Identities0.IDENTITY_T_ORDER_ITEM;
    public static final Identity<TPrinterRecord, UInteger> IDENTITY_T_PRINTER = Identities0.IDENTITY_T_PRINTER;
    public static final Identity<TRechargeRecordRecord, UInteger> IDENTITY_T_RECHARGE_RECORD = Identities0.IDENTITY_T_RECHARGE_RECORD;
    public static final Identity<TSceneRecord, UInteger> IDENTITY_T_SCENE = Identities0.IDENTITY_T_SCENE;
    public static final Identity<TShopChargeRecordRecord, UInteger> IDENTITY_T_SHOP_CHARGE_RECORD = Identities0.IDENTITY_T_SHOP_CHARGE_RECORD;
    public static final Identity<TShopChargeRecordBalanceRecord, UInteger> IDENTITY_T_SHOP_CHARGE_RECORD_BALANCE = Identities0.IDENTITY_T_SHOP_CHARGE_RECORD_BALANCE;
    public static final Identity<TTableRecord, Integer> IDENTITY_T_TABLE = Identities0.IDENTITY_T_TABLE;
    public static final Identity<TTasteRecord, UInteger> IDENTITY_T_TASTE = Identities0.IDENTITY_T_TASTE;
    public static final Identity<TTopupRecord, UInteger> IDENTITY_T_TOPUP = Identities0.IDENTITY_T_TOPUP;
    public static final Identity<TUserRecord, Integer> IDENTITY_T_USER = Identities0.IDENTITY_T_USER;
    public static final Identity<TUserBalanceRecord, UInteger> IDENTITY_T_USER_BALANCE = Identities0.IDENTITY_T_USER_BALANCE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TActivityRecord> KEY_T_ACTIVITY_PRIMARY = UniqueKeys0.KEY_T_ACTIVITY_PRIMARY;
    public static final UniqueKey<TActivityMinusRecord> KEY_T_ACTIVITY_MINUS_PRIMARY = UniqueKeys0.KEY_T_ACTIVITY_MINUS_PRIMARY;
    public static final UniqueKey<TActivityNewuserRecord> KEY_T_ACTIVITY_NEWUSER_PRIMARY = UniqueKeys0.KEY_T_ACTIVITY_NEWUSER_PRIMARY;
    public static final UniqueKey<TAddressRecord> KEY_T_ADDRESS_PRIMARY = UniqueKeys0.KEY_T_ADDRESS_PRIMARY;
    public static final UniqueKey<TBankAccountRecord> KEY_T_BANK_ACCOUNT_PRIMARY = UniqueKeys0.KEY_T_BANK_ACCOUNT_PRIMARY;
    public static final UniqueKey<TCategoryRecord> KEY_T_CATEGORY_PRIMARY = UniqueKeys0.KEY_T_CATEGORY_PRIMARY;
    public static final UniqueKey<TChargeApplyRecord> KEY_T_CHARGE_APPLY_PRIMARY = UniqueKeys0.KEY_T_CHARGE_APPLY_PRIMARY;
    public static final UniqueKey<TConfigRecord> KEY_T_CONFIG_PRIMARY = UniqueKeys0.KEY_T_CONFIG_PRIMARY;
    public static final UniqueKey<TCorpRecord> KEY_T_CORP_PRIMARY = UniqueKeys0.KEY_T_CORP_PRIMARY;
    public static final UniqueKey<TCorpCollectRecord> KEY_T_CORP_COLLECT_PRIMARY = UniqueKeys0.KEY_T_CORP_COLLECT_PRIMARY;
    public static final UniqueKey<TCorpDiscoverRecord> KEY_T_CORP_DISCOVER_PRIMARY = UniqueKeys0.KEY_T_CORP_DISCOVER_PRIMARY;
    public static final UniqueKey<TCorpFeedbackRecord> KEY_T_CORP_FEEDBACK_PRIMARY = UniqueKeys0.KEY_T_CORP_FEEDBACK_PRIMARY;
    public static final UniqueKey<TCorpTotalRecord> KEY_T_CORP_TOTAL_PRIMARY = UniqueKeys0.KEY_T_CORP_TOTAL_PRIMARY;
    public static final UniqueKey<TCorpUserRecord> KEY_T_CORP_USER_PRIMARY = UniqueKeys0.KEY_T_CORP_USER_PRIMARY;
    public static final UniqueKey<TCorpUserRoleRecord> KEY_T_CORP_USER_ROLE_PRIMARY = UniqueKeys0.KEY_T_CORP_USER_ROLE_PRIMARY;
    public static final UniqueKey<TCorpUserRoleRecord> KEY_T_CORP_USER_ROLE_USERNAME = UniqueKeys0.KEY_T_CORP_USER_ROLE_USERNAME;
    public static final UniqueKey<TDadaMerchantRecord> KEY_T_DADA_MERCHANT_PRIMARY = UniqueKeys0.KEY_T_DADA_MERCHANT_PRIMARY;
    public static final UniqueKey<TDeliveryShopRecord> KEY_T_DELIVERY_SHOP_PRIMARY = UniqueKeys0.KEY_T_DELIVERY_SHOP_PRIMARY;
    public static final UniqueKey<TDeliveryTransportRecord> KEY_T_DELIVERY_TRANSPORT_PRIMARY = UniqueKeys0.KEY_T_DELIVERY_TRANSPORT_PRIMARY;
    public static final UniqueKey<TDeliveryTransportRecord> KEY_T_DELIVERY_TRANSPORT_ORDER_NO = UniqueKeys0.KEY_T_DELIVERY_TRANSPORT_ORDER_NO;
    public static final UniqueKey<TFeieprinterRecord> KEY_T_FEIEPRINTER_PRIMARY = UniqueKeys0.KEY_T_FEIEPRINTER_PRIMARY;
    public static final UniqueKey<TFormatRecord> KEY_T_FORMAT_PRIMARY = UniqueKeys0.KEY_T_FORMAT_PRIMARY;
    public static final UniqueKey<TItemRecord> KEY_T_ITEM_PRIMARY = UniqueKeys0.KEY_T_ITEM_PRIMARY;
    public static final UniqueKey<TOrderRecord> KEY_T_ORDER_PRIMARY = UniqueKeys0.KEY_T_ORDER_PRIMARY;
    public static final UniqueKey<TOrderItemRecord> KEY_T_ORDER_ITEM_PRIMARY = UniqueKeys0.KEY_T_ORDER_ITEM_PRIMARY;
    public static final UniqueKey<TPrinterRecord> KEY_T_PRINTER_PRIMARY = UniqueKeys0.KEY_T_PRINTER_PRIMARY;
    public static final UniqueKey<TRechargeRecordRecord> KEY_T_RECHARGE_RECORD_PRIMARY = UniqueKeys0.KEY_T_RECHARGE_RECORD_PRIMARY;
    public static final UniqueKey<TSceneRecord> KEY_T_SCENE_PRIMARY = UniqueKeys0.KEY_T_SCENE_PRIMARY;
    public static final UniqueKey<TShopChargeRecordRecord> KEY_T_SHOP_CHARGE_RECORD_PRIMARY = UniqueKeys0.KEY_T_SHOP_CHARGE_RECORD_PRIMARY;
    public static final UniqueKey<TShopChargeRecordBalanceRecord> KEY_T_SHOP_CHARGE_RECORD_BALANCE_PRIMARY = UniqueKeys0.KEY_T_SHOP_CHARGE_RECORD_BALANCE_PRIMARY;
    public static final UniqueKey<TTableRecord> KEY_T_TABLE_PRIMARY = UniqueKeys0.KEY_T_TABLE_PRIMARY;
    public static final UniqueKey<TTasteRecord> KEY_T_TASTE_PRIMARY = UniqueKeys0.KEY_T_TASTE_PRIMARY;
    public static final UniqueKey<TTopupRecord> KEY_T_TOPUP_PRIMARY = UniqueKeys0.KEY_T_TOPUP_PRIMARY;
    public static final UniqueKey<TUserRecord> KEY_T_USER_PRIMARY = UniqueKeys0.KEY_T_USER_PRIMARY;
    public static final UniqueKey<TUserBalanceRecord> KEY_T_USER_BALANCE_PRIMARY = UniqueKeys0.KEY_T_USER_BALANCE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<TActivityRecord, UInteger> IDENTITY_T_ACTIVITY = createIdentity(TActivity.T_ACTIVITY, TActivity.T_ACTIVITY.ID);
        public static Identity<TActivityMinusRecord, UInteger> IDENTITY_T_ACTIVITY_MINUS = createIdentity(TActivityMinus.T_ACTIVITY_MINUS, TActivityMinus.T_ACTIVITY_MINUS.ID);
        public static Identity<TActivityNewuserRecord, UInteger> IDENTITY_T_ACTIVITY_NEWUSER = createIdentity(TActivityNewuser.T_ACTIVITY_NEWUSER, TActivityNewuser.T_ACTIVITY_NEWUSER.ID);
        public static Identity<TAddressRecord, UInteger> IDENTITY_T_ADDRESS = createIdentity(TAddress.T_ADDRESS, TAddress.T_ADDRESS.ID);
        public static Identity<TBankAccountRecord, UInteger> IDENTITY_T_BANK_ACCOUNT = createIdentity(TBankAccount.T_BANK_ACCOUNT, TBankAccount.T_BANK_ACCOUNT.ID);
        public static Identity<TCategoryRecord, Integer> IDENTITY_T_CATEGORY = createIdentity(TCategory.T_CATEGORY, TCategory.T_CATEGORY.ID);
        public static Identity<TChargeApplyRecord, Integer> IDENTITY_T_CHARGE_APPLY = createIdentity(TChargeApply.T_CHARGE_APPLY, TChargeApply.T_CHARGE_APPLY.ID);
        public static Identity<TConfigRecord, UInteger> IDENTITY_T_CONFIG = createIdentity(TConfig.T_CONFIG, TConfig.T_CONFIG.ID);
        public static Identity<TCorpRecord, UInteger> IDENTITY_T_CORP = createIdentity(TCorp.T_CORP, TCorp.T_CORP.ID);
        public static Identity<TCorpCollectRecord, Integer> IDENTITY_T_CORP_COLLECT = createIdentity(TCorpCollect.T_CORP_COLLECT, TCorpCollect.T_CORP_COLLECT.ID);
        public static Identity<TCorpDiscoverRecord, Integer> IDENTITY_T_CORP_DISCOVER = createIdentity(TCorpDiscover.T_CORP_DISCOVER, TCorpDiscover.T_CORP_DISCOVER.ID);
        public static Identity<TCorpFeedbackRecord, Integer> IDENTITY_T_CORP_FEEDBACK = createIdentity(TCorpFeedback.T_CORP_FEEDBACK, TCorpFeedback.T_CORP_FEEDBACK.ID);
        public static Identity<TCorpTotalRecord, Integer> IDENTITY_T_CORP_TOTAL = createIdentity(TCorpTotal.T_CORP_TOTAL, TCorpTotal.T_CORP_TOTAL.ID);
        public static Identity<TCorpUserRecord, Integer> IDENTITY_T_CORP_USER = createIdentity(TCorpUser.T_CORP_USER, TCorpUser.T_CORP_USER.ID);
        public static Identity<TCorpUserRoleRecord, UInteger> IDENTITY_T_CORP_USER_ROLE = createIdentity(TCorpUserRole.T_CORP_USER_ROLE, TCorpUserRole.T_CORP_USER_ROLE.ID);
        public static Identity<TDadaMerchantRecord, UInteger> IDENTITY_T_DADA_MERCHANT = createIdentity(TDadaMerchant.T_DADA_MERCHANT, TDadaMerchant.T_DADA_MERCHANT.ID);
        public static Identity<TDeliveryShopRecord, UInteger> IDENTITY_T_DELIVERY_SHOP = createIdentity(TDeliveryShop.T_DELIVERY_SHOP, TDeliveryShop.T_DELIVERY_SHOP.ID);
        public static Identity<TDeliveryTransportRecord, UInteger> IDENTITY_T_DELIVERY_TRANSPORT = createIdentity(TDeliveryTransport.T_DELIVERY_TRANSPORT, TDeliveryTransport.T_DELIVERY_TRANSPORT.ID);
        public static Identity<TFeieprinterRecord, UInteger> IDENTITY_T_FEIEPRINTER = createIdentity(TFeieprinter.T_FEIEPRINTER, TFeieprinter.T_FEIEPRINTER.ID);
        public static Identity<TFormatRecord, UInteger> IDENTITY_T_FORMAT = createIdentity(TFormat.T_FORMAT, TFormat.T_FORMAT.ID);
        public static Identity<TItemRecord, Integer> IDENTITY_T_ITEM = createIdentity(TItem.T_ITEM, TItem.T_ITEM.ID);
        public static Identity<TOrderRecord, Integer> IDENTITY_T_ORDER = createIdentity(TOrder.T_ORDER, TOrder.T_ORDER.ID);
        public static Identity<TOrderItemRecord, Integer> IDENTITY_T_ORDER_ITEM = createIdentity(TOrderItem.T_ORDER_ITEM, TOrderItem.T_ORDER_ITEM.ID);
        public static Identity<TPrinterRecord, UInteger> IDENTITY_T_PRINTER = createIdentity(TPrinter.T_PRINTER, TPrinter.T_PRINTER.ID);
        public static Identity<TRechargeRecordRecord, UInteger> IDENTITY_T_RECHARGE_RECORD = createIdentity(TRechargeRecord.T_RECHARGE_RECORD, TRechargeRecord.T_RECHARGE_RECORD.ID);
        public static Identity<TSceneRecord, UInteger> IDENTITY_T_SCENE = createIdentity(TScene.T_SCENE, TScene.T_SCENE.ID);
        public static Identity<TShopChargeRecordRecord, UInteger> IDENTITY_T_SHOP_CHARGE_RECORD = createIdentity(TShopChargeRecord.T_SHOP_CHARGE_RECORD, TShopChargeRecord.T_SHOP_CHARGE_RECORD.ID);
        public static Identity<TShopChargeRecordBalanceRecord, UInteger> IDENTITY_T_SHOP_CHARGE_RECORD_BALANCE = createIdentity(TShopChargeRecordBalance.T_SHOP_CHARGE_RECORD_BALANCE, TShopChargeRecordBalance.T_SHOP_CHARGE_RECORD_BALANCE.ID);
        public static Identity<TTableRecord, Integer> IDENTITY_T_TABLE = createIdentity(TTable.T_TABLE, TTable.T_TABLE.ID);
        public static Identity<TTasteRecord, UInteger> IDENTITY_T_TASTE = createIdentity(TTaste.T_TASTE, TTaste.T_TASTE.ID);
        public static Identity<TTopupRecord, UInteger> IDENTITY_T_TOPUP = createIdentity(TTopup.T_TOPUP, TTopup.T_TOPUP.ID);
        public static Identity<TUserRecord, Integer> IDENTITY_T_USER = createIdentity(TUser.T_USER, TUser.T_USER.ID);
        public static Identity<TUserBalanceRecord, UInteger> IDENTITY_T_USER_BALANCE = createIdentity(TUserBalance.T_USER_BALANCE, TUserBalance.T_USER_BALANCE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<TActivityRecord> KEY_T_ACTIVITY_PRIMARY = createUniqueKey(TActivity.T_ACTIVITY, "KEY_t_activity_PRIMARY", TActivity.T_ACTIVITY.ID);
        public static final UniqueKey<TActivityMinusRecord> KEY_T_ACTIVITY_MINUS_PRIMARY = createUniqueKey(TActivityMinus.T_ACTIVITY_MINUS, "KEY_t_activity_minus_PRIMARY", TActivityMinus.T_ACTIVITY_MINUS.ID);
        public static final UniqueKey<TActivityNewuserRecord> KEY_T_ACTIVITY_NEWUSER_PRIMARY = createUniqueKey(TActivityNewuser.T_ACTIVITY_NEWUSER, "KEY_t_activity_newuser_PRIMARY", TActivityNewuser.T_ACTIVITY_NEWUSER.ID);
        public static final UniqueKey<TAddressRecord> KEY_T_ADDRESS_PRIMARY = createUniqueKey(TAddress.T_ADDRESS, "KEY_t_address_PRIMARY", TAddress.T_ADDRESS.ID);
        public static final UniqueKey<TBankAccountRecord> KEY_T_BANK_ACCOUNT_PRIMARY = createUniqueKey(TBankAccount.T_BANK_ACCOUNT, "KEY_t_bank_account_PRIMARY", TBankAccount.T_BANK_ACCOUNT.ID);
        public static final UniqueKey<TCategoryRecord> KEY_T_CATEGORY_PRIMARY = createUniqueKey(TCategory.T_CATEGORY, "KEY_t_category_PRIMARY", TCategory.T_CATEGORY.ID);
        public static final UniqueKey<TChargeApplyRecord> KEY_T_CHARGE_APPLY_PRIMARY = createUniqueKey(TChargeApply.T_CHARGE_APPLY, "KEY_t_charge_apply_PRIMARY", TChargeApply.T_CHARGE_APPLY.ID);
        public static final UniqueKey<TConfigRecord> KEY_T_CONFIG_PRIMARY = createUniqueKey(TConfig.T_CONFIG, "KEY_t_config_PRIMARY", TConfig.T_CONFIG.ID);
        public static final UniqueKey<TCorpRecord> KEY_T_CORP_PRIMARY = createUniqueKey(TCorp.T_CORP, "KEY_t_corp_PRIMARY", TCorp.T_CORP.ID);
        public static final UniqueKey<TCorpCollectRecord> KEY_T_CORP_COLLECT_PRIMARY = createUniqueKey(TCorpCollect.T_CORP_COLLECT, "KEY_t_corp_collect_PRIMARY", TCorpCollect.T_CORP_COLLECT.ID);
        public static final UniqueKey<TCorpDiscoverRecord> KEY_T_CORP_DISCOVER_PRIMARY = createUniqueKey(TCorpDiscover.T_CORP_DISCOVER, "KEY_t_corp_discover_PRIMARY", TCorpDiscover.T_CORP_DISCOVER.ID);
        public static final UniqueKey<TCorpFeedbackRecord> KEY_T_CORP_FEEDBACK_PRIMARY = createUniqueKey(TCorpFeedback.T_CORP_FEEDBACK, "KEY_t_corp_feedback_PRIMARY", TCorpFeedback.T_CORP_FEEDBACK.ID);
        public static final UniqueKey<TCorpTotalRecord> KEY_T_CORP_TOTAL_PRIMARY = createUniqueKey(TCorpTotal.T_CORP_TOTAL, "KEY_t_corp_total_PRIMARY", TCorpTotal.T_CORP_TOTAL.ID);
        public static final UniqueKey<TCorpUserRecord> KEY_T_CORP_USER_PRIMARY = createUniqueKey(TCorpUser.T_CORP_USER, "KEY_t_corp_user_PRIMARY", TCorpUser.T_CORP_USER.ID);
        public static final UniqueKey<TCorpUserRoleRecord> KEY_T_CORP_USER_ROLE_PRIMARY = createUniqueKey(TCorpUserRole.T_CORP_USER_ROLE, "KEY_t_corp_user_role_PRIMARY", TCorpUserRole.T_CORP_USER_ROLE.ID);
        public static final UniqueKey<TCorpUserRoleRecord> KEY_T_CORP_USER_ROLE_USERNAME = createUniqueKey(TCorpUserRole.T_CORP_USER_ROLE, "KEY_t_corp_user_role_username", TCorpUserRole.T_CORP_USER_ROLE.USERNAME, TCorpUserRole.T_CORP_USER_ROLE.ROLE);
        public static final UniqueKey<TDadaMerchantRecord> KEY_T_DADA_MERCHANT_PRIMARY = createUniqueKey(TDadaMerchant.T_DADA_MERCHANT, "KEY_t_dada_merchant_PRIMARY", TDadaMerchant.T_DADA_MERCHANT.ID);
        public static final UniqueKey<TDeliveryShopRecord> KEY_T_DELIVERY_SHOP_PRIMARY = createUniqueKey(TDeliveryShop.T_DELIVERY_SHOP, "KEY_t_delivery_shop_PRIMARY", TDeliveryShop.T_DELIVERY_SHOP.ID);
        public static final UniqueKey<TDeliveryTransportRecord> KEY_T_DELIVERY_TRANSPORT_PRIMARY = createUniqueKey(TDeliveryTransport.T_DELIVERY_TRANSPORT, "KEY_t_delivery_transport_PRIMARY", TDeliveryTransport.T_DELIVERY_TRANSPORT.ID);
        public static final UniqueKey<TDeliveryTransportRecord> KEY_T_DELIVERY_TRANSPORT_ORDER_NO = createUniqueKey(TDeliveryTransport.T_DELIVERY_TRANSPORT, "KEY_t_delivery_transport_order_no", TDeliveryTransport.T_DELIVERY_TRANSPORT.ORDER_NO);
        public static final UniqueKey<TFeieprinterRecord> KEY_T_FEIEPRINTER_PRIMARY = createUniqueKey(TFeieprinter.T_FEIEPRINTER, "KEY_t_feieprinter_PRIMARY", TFeieprinter.T_FEIEPRINTER.ID);
        public static final UniqueKey<TFormatRecord> KEY_T_FORMAT_PRIMARY = createUniqueKey(TFormat.T_FORMAT, "KEY_t_format_PRIMARY", TFormat.T_FORMAT.ID);
        public static final UniqueKey<TItemRecord> KEY_T_ITEM_PRIMARY = createUniqueKey(TItem.T_ITEM, "KEY_t_item_PRIMARY", TItem.T_ITEM.ID);
        public static final UniqueKey<TOrderRecord> KEY_T_ORDER_PRIMARY = createUniqueKey(TOrder.T_ORDER, "KEY_t_order_PRIMARY", TOrder.T_ORDER.ID);
        public static final UniqueKey<TOrderItemRecord> KEY_T_ORDER_ITEM_PRIMARY = createUniqueKey(TOrderItem.T_ORDER_ITEM, "KEY_t_order_item_PRIMARY", TOrderItem.T_ORDER_ITEM.ID);
        public static final UniqueKey<TPrinterRecord> KEY_T_PRINTER_PRIMARY = createUniqueKey(TPrinter.T_PRINTER, "KEY_t_printer_PRIMARY", TPrinter.T_PRINTER.ID);
        public static final UniqueKey<TRechargeRecordRecord> KEY_T_RECHARGE_RECORD_PRIMARY = createUniqueKey(TRechargeRecord.T_RECHARGE_RECORD, "KEY_t_recharge_record_PRIMARY", TRechargeRecord.T_RECHARGE_RECORD.ID);
        public static final UniqueKey<TSceneRecord> KEY_T_SCENE_PRIMARY = createUniqueKey(TScene.T_SCENE, "KEY_t_scene_PRIMARY", TScene.T_SCENE.ID);
        public static final UniqueKey<TShopChargeRecordRecord> KEY_T_SHOP_CHARGE_RECORD_PRIMARY = createUniqueKey(TShopChargeRecord.T_SHOP_CHARGE_RECORD, "KEY_t_shop_charge_record_PRIMARY", TShopChargeRecord.T_SHOP_CHARGE_RECORD.ID);
        public static final UniqueKey<TShopChargeRecordBalanceRecord> KEY_T_SHOP_CHARGE_RECORD_BALANCE_PRIMARY = createUniqueKey(TShopChargeRecordBalance.T_SHOP_CHARGE_RECORD_BALANCE, "KEY_t_shop_charge_record_balance_PRIMARY", TShopChargeRecordBalance.T_SHOP_CHARGE_RECORD_BALANCE.ID);
        public static final UniqueKey<TTableRecord> KEY_T_TABLE_PRIMARY = createUniqueKey(TTable.T_TABLE, "KEY_t_table_PRIMARY", TTable.T_TABLE.ID);
        public static final UniqueKey<TTasteRecord> KEY_T_TASTE_PRIMARY = createUniqueKey(TTaste.T_TASTE, "KEY_t_taste_PRIMARY", TTaste.T_TASTE.ID);
        public static final UniqueKey<TTopupRecord> KEY_T_TOPUP_PRIMARY = createUniqueKey(TTopup.T_TOPUP, "KEY_t_topup_PRIMARY", TTopup.T_TOPUP.ID);
        public static final UniqueKey<TUserRecord> KEY_T_USER_PRIMARY = createUniqueKey(TUser.T_USER, "KEY_t_user_PRIMARY", TUser.T_USER.ID);
        public static final UniqueKey<TUserBalanceRecord> KEY_T_USER_BALANCE_PRIMARY = createUniqueKey(TUserBalance.T_USER_BALANCE, "KEY_t_user_balance_PRIMARY", TUserBalance.T_USER_BALANCE.ID);
    }
}
