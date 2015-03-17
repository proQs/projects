/**
 * 
 */
package PS.admin.common;

/**
 * @author Kelvin
 * 
 */
public class Config {

	public static String key1 = "IUUhp5789iIUP0APUg2H98gf23viusab";
	
	public final static long ONE_DAY = 60 * 60 * 24 * 1000;
	public final static long THREE_DAY = ONE_DAY * 3;
	public final static long SEVEN_DAY = ONE_DAY * 7;

	// System 0 ~ 9999
	public static final int Log_StartServer = 0;
	public static final int Log_StartServerSuccess = 1;
	public static final int Log_StopServer = 2;
	public static final int Log_StopServerSuccess = 3;
	public static final int GM_Command = 100;

	public static final int Log_Login = 10000;
	public static final int Log_CreateUser = Log_Login + 1;
	public static final int Log_PlayerAtFormation = Log_CreateUser + 1;
	// User Data Change
	public static final int Log_UserLevelUp = 20000;
	public static final int Log_UserAddXp = Log_UserLevelUp + 1;
	public static final int Log_Shop = Log_UserAddXp + 1;
	public static final int Log_ShopFailed = Log_Shop + 1;
	public static final int Log_AchiOrTask = Log_ShopFailed + 1;
	public static final int Log_SkillStrengthen = Log_AchiOrTask + 1;
	public static final int Log_AchieveRewardOrTaskReward = Log_SkillStrengthen + 1;
	public static final int LOG_SkillMosaic = Log_AchieveRewardOrTaskReward + 1;
	public static final int Log_Pay = LOG_SkillMosaic + 1;
	public static final int Log_TaskVitalityReward = Log_Pay + 1;
	public static final int Log_Dailywelfare = Log_TaskVitalityReward + 1;
	public static final int Log_BuyVIPBag = Log_Dailywelfare + 1;
	public static final int Log_subBuyVIPBag = Log_BuyVIPBag + 1;
	public static final int Log_PropsGetOrRemove = Log_subBuyVIPBag + 1;
	public static final int Log_Add_or_ReduceMoney = Log_PropsGetOrRemove + 1;
	public static final int Log_TradeShelf = Log_Add_or_ReduceMoney + 1;
	public static final int Log_TradeFailed = Log_TradeShelf + 1;
	public static final int Log_TradeBuy = Log_TradeFailed + 1;
	public static final int Log_EquipSold = Log_TradeBuy + 1;
	public static final int Log_ExtendBag = Log_EquipSold + 1;
	public static final int Log_Trade_seller = Log_ExtendBag + 1;
	public static final int Log_FormationLeveUp = Log_Trade_seller + 1;
	public static final int Log_BossStimulate = Log_FormationLeveUp + 1;
	public static final int Log_BossStimulateFailed = Log_BossStimulate + 1;
	public static final int Log_BossClearTime = Log_BossStimulateFailed + 1;
	public static final int Log_BossReward = Log_BossClearTime + 1;
	public static final int Log_CompositeFragment = Log_BossReward + 1;
	public static final int Log_CardAdvanced = Log_CompositeFragment + 1;
	public static final int Log_PVPRefeshList = Log_CardAdvanced + 1;
	public static final int Log_InheritPlayer = Log_PVPRefeshList + 1;
	public static final int Log_ReduceEnergy = Log_InheritPlayer + 1;
	public static final int Log_Friend = Log_ReduceEnergy + 1;
	public static final int Log_Friendopposite = Log_Friend + 1;
	public static final int Log_GetFriendGift = Log_Friendopposite + 1;
	public static final int Log_SendFriendGift = Log_GetFriendGift + 1;
	public static final int Log_PropsAddFriendXP = Log_SendFriendGift + 1;
	public static final int Log_PVPReward = Log_PropsAddFriendXP + 1;
	public static final int Log_PVPCardLv = Log_PVPReward + 1;
	public static final int Log_PVPExchange = Log_PVPCardLv + 1;
	public static final int Log_SlotCard = Log_PVPExchange + 1;
	public static final int Log_PvpRankReward = Log_SlotCard + 1;
	public static final int Log_MailGet = Log_PvpRankReward + 1;
	public static final int Log_StageBattle = Log_MailGet + 1;
	public static final int Log_Smelt = Log_StageBattle + 1;
	public static final int Log_SmeltReward = Log_Smelt + 1;
	public static final int Log_Resign = Log_SmeltReward + 1;
	public static final int Log_ResignFailed = Log_Resign + 1;
	public static final int Log_SmeltScoreReward = Log_ResignFailed + 1;
	public static final int Log_SpecialStage = Log_SmeltScoreReward + 1;
	public static final int Log_Battle = Log_SpecialStage + 1;
	public static final int Log_BattleAddBuff = Log_Battle + 1;
	public static final int Log_BattleReply = Log_BattleAddBuff + 1;
	public static final int Log_BattleReplyFailed = Log_BattleReply + 1;
	public static final int Log_BattleReward = Log_BattleReplyFailed + 1;
	public static final int Log_Eating = Log_BattleReward + 1;
	public static final int Log_UseManualProp = Log_Eating + 1;
	public static final int Log_UseEnergyProp = Log_UseManualProp + 1;
	public static final int Log_OpenTreauser = Log_UseEnergyProp + 1;
	public static final int Log_CardXp = Log_OpenTreauser + 1;
	public static final int Log_StageReset = Log_CardXp + 1;
	public static final int Log_SignIn = Log_StageReset + 1;
	public static final int Log_ReSign = Log_SignIn + 1;
	public static final int Log_SignReward = Log_ReSign + 1;
	public static final int Log_FriendExpBag = Log_SignReward + 1;
	public static final int Log_FriendExpBagFailed = Log_FriendExpBag + 1;
	public static final int Log_TradeExpBag = Log_FriendExpBagFailed + 1;
	public static final int Log_FailedTradeExpBag = Log_TradeExpBag + 1;
	public static final int Log_FriendInvite = Log_FailedTradeExpBag + 1;
	public static final int Log_GoldPower = Log_FriendInvite + 1;
	public static final int Log_ExtendDragonSlot = Log_GoldPower + 1;
	public static final int Log_ChangDragon = Log_ExtendDragonSlot + 1;
	public static final int Log_RemoveDragonBall = Log_ChangDragon + 1;
	public static final int Log_EquipStrength = Log_RemoveDragonBall + 1;
	public static final int Log_SweepStage = Log_EquipStrength + 1;
	public static final int Log_ResetUnionTrained = Log_SweepStage + 1;
	public static final int Log_ResetTrained = Log_ResetUnionTrained + 1;
	public static final int Log_CreateUnion = Log_ResetTrained + 1;
	public static final int Log_UnionContribute = Log_CreateUnion + 1;
	public static final int Log_UnionBattle = Log_UnionContribute + 1;
	public static final int Log_UnionBattleRecover = Log_UnionBattle + 1;
	public static final int Log_UnionBattleRevive = Log_UnionBattleRecover + 1;
	public static final int Log_UnionGoods = Log_UnionBattleRevive + 1;
	public static final int Log_RefushUnionShop = Log_UnionGoods + 1;
	public static final int Log_UnionDemonsBattle = Log_RefushUnionShop + 1;
	public static final int Log_UnionDemonsReward = Log_UnionDemonsBattle + 1;
	
	/**
	 * 分页参数初始化值：默认显示第几页
	 */
	public static final int default_pageNumber = 1;
	
	/**
	 * 分页参数初始化值：默认每页显示几多
	 */
	public static final int default_pageSize = 10;
	
	/**
	 *  主数据源名称：系统主数据源
	 */
	public static final String db_dataSource_main = "main";

}
