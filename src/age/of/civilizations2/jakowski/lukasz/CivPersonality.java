package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

class CivPersonality implements Serializable {
   private static final long serialVersionUID = 0L;
   protected int REBUILD_PERSONALITY_MORE_OFTEN = 12;
   protected float TAXATION_LEVEL = 0.95F;
   protected float USE_OF_BUDGET_FOR_SPENDINGS = 1.0F;
   protected float TREASURY_RESERVE = 10.0F;
   protected float TREASURY_RESERVE_MODIFIER = 0.1F;
   protected float GOODS_EXTRA_PERC_OF_BUDGET = 0.25F;
   protected float INVESTMENTS_EXTRA_PERC_OF_BUDGET = 0.25F;
   protected float RESEARCH_PERC_OF_BUDGET = 0.2F;
   protected float MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY = 0.75F;
   protected float MIN_MILITARY_SPENDINGS = 0.2F;
   protected float MIN_MILITARY_SPENDINGS_WAR = 0.2F;
   protected float MIN_MILITARY_SPENDINGS_WAR_MODIFIER = 1.1F;
   protected float MIN_MILITARY_SPENDINGS_RECRUIT_AT_WAR = 0.9F;
   protected float MIN_MILITARY_SPENDINGS_NOT_BORDERING_WITH_ENEMY = 0.6F;
   protected int MIN_HAPPINESS_FOR_CIV = 65;
   protected int MIN_HAPPINESS_CRISIS = 65;
   protected int REGROUP_AT_PEACE_MAX_PROVINCES = 10;
   protected float REGROUP_AT_PEACE_DISBAND_IF_LESS_THAN_PERC = 0.025F;
   protected float AGGRESSION = 50.0F;
   protected int DEFENSE = 50;
   protected int EXPANSION = 50;
   protected int FRIENSHIP_WILLINGNESS = 50;
   protected int NEUTRALITY = 50;
   protected int LOYALITY = 50;
   protected float FORGIVENESS = 1.0F;
   protected float PLUNDER_CHANCE = 0.22F;
   protected float POTENTIAL_POPULATION = 27.5F;
   protected float POTENTIAL_ECONOMY = 27.5F;
   protected float DANGER_EXTRA_KEY_REGION = 1.75F;
   protected float DANGER_EXTRA_PER_OWN_PROVINCE = 0.1F;
   protected float DANGER_PERC_OF_UNITS = 0.1F;
   protected int WAR_CLOSE_REGION_PROVINCES = 5;
   protected float WAR_CLOSE_REGION_EXTRA_SCORE = 1.25F;
   protected float MIN_PROVINCE_STABILITY = 0.75F;
   protected float MIN_HAPPINESS_TO_ASSMILIATE_PROVINCE = 0.48F;
   protected float ASSIMILATE_PERC_DISTANCE_SCORE = 0.33F;
   protected float ASSIMILATE_PERC_LOW_STABILITY_SCORE = 0.33F;
   protected float ASSIMILATE_PERC_POPULATION_SCORE = 0.33F;
   protected float MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL = 0.7F;
   protected float BUILD_MIN_STABILITY = 0.75F;
   protected float BUILD_MAX_REV_RISK = 0.05F;
   protected float BUILD_STABILITY_SCORE = 0.65F;
   protected float BUILD_DANGER_SCORE = 0.5F;
   protected float BUILD_FORT = 0.5F;
   protected float BUILD_TOWER = 0.5F;
   protected float BUILD_PORT = 0.5F;
   protected float BUILD_FARM = 0.5F;
   protected float BUILD_WORKSHOP = 0.5F;
   protected float BUILD_WORKSHOP_POP_SCORE = 0.5F;
   protected float BUILD_WORKSHOP_ECO_SCORE = 0.5F;
   protected float BUILD_LIBRARY = 0.5F;
   protected float BUILD_ARMOURY = 0.5F;
   protected float BUILD_ARMOURY_RECRUITABLE_SCORE = 0.5F;
   protected float BUILD_SUPPLYLINE = 0.5F;
   protected float BUILD_INVEST = 0.5F;
   protected float BUILD_INVEST_DEVELOPMENT = 0.5F;
   protected float BUILD_INVEST_POP_SCORE = 0.5F;
   protected float BUILD_INVEST_DEVELOPMENT_SCORE = 0.5F;
   protected float BUILD_INVEST_POP_ECO_DIFFERENCE_SCORE = 0.5F;
   protected int BUILD_RESRVE_RAND = 10;
   protected int BUILD_INVEST_SECOND_INVEST_MAX_PERC = 30;
   protected int BUILD_INVEST_SECOND_INVEST_CHANCE = 20;
   protected float COLONIZATION_SEA = 20.0F;
   protected float COLONIZATION_OWN_PROVINCES = 20.0F;
   protected float COLONIZATION_GROWTH_RATE = 20.0F;
   protected float COLONIZATION_DISTANCE = 20.0F;
   protected float NEUTRAL_EXPAND_CAPITAL = 22.0F;
   protected float NEUTRAL_EXPAND_OWN_PROVINCE = 10.0F;
   protected float NEUTRAL_EXPAND_MORE_NEUTRAL = 4.0F;
   protected float NEUTRAL_EXPAND_OTHER_CIV = 4.0F;
   protected float NEUTRAL_EXPAND_GROWTH_RATE = 75.0F;
   protected float NEUTRAL_EXPAND_LAST_PROVINCE = 75.0F;
   protected float NEUTRAL_EXPAND_SEA_ACCESS = 20.0F;
   protected float NEUTRAL_EXPAND_SEA_ACCESS_EXTRA = 3.0F;
   protected float NEUTRAL_EXPAND_NEIGHBORING_PROVINCES = 3.0F;
   protected float NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENITAL = 25.0F;
   protected int UNCIVILIZED_WILLING_TO_CIVILIZE = 50;
   protected int UNCIVILIZED_MIGRATE = 50;
   protected int UNCIVILIZED_POPULATION = 50;
   protected int UNCIVILIZED_INVESTMENTS = 50;
   protected float VALUABLE_POTENTIAL = 1.0F;
   protected float VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE = 1.0F;
   protected float VALUABLE_DANGER = 1.0F;
   protected float VALUABLE_REGION_NUM_OF_PROVINCES = 0.4F;
   protected float VALUABLE_REGION_POTENTIAL = 0.4F;
   protected float VALUABLE_NUM_OF_UNITS = 0.825F;
   protected float VALUABLE_NUM_OF_UNITS_RECRUITMENT = 0.0F;
   protected int VALUABLE_RECRUIT_FROM_FAR_AWAY_CHANCE = 0;
   protected float WAR_POTENTIAL = 1.0F;
   protected float WAR_DANGER = 1.0F;
   protected float WAR_NUM_OF_UNITS = 0.825F;
   protected float WAR_REGION_NUM_OF_PROVINCES = 0.4F;
   protected float WAR_REGION_POTENTIAL = 0.4F;
   protected float WAR_ATTACK_SCORE_ARMY = 0.45F;
   protected float WAR_ATTACK_SCORE_POTENTIAL = 0.525F;
   protected float WAR_ATTACK_SCORE_WAS_CONQUERED = 0.4F;
   protected int WAR_REGROUP_SPLIT_MIN = 1;
   protected int WAR_REGROUP_SPLIT_EXTRA = 1;
   protected float WAR_ATTACK_NAVAL_DISTANCE = 0.4F;
   protected float WAR_ATTACK_DISTANCE = 0.4F;
   protected float RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE = 20.0F;
   protected float RESPONSE_MILITARY_ACCESS_RELATION_SCORE = 41.25F;
   protected float RESPONSE_MILITARY_ACCESS_RANK_SCORE = 6.45F;
   protected float RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE = 8.25F;
   protected float RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE = 5.75F;
   protected float HRE_VOTE_FOR_RANK = 18.0F;
   protected float HRE_VOTE_FOR_PROVINCES = 22.0F;
   protected float RESPONSE_ALLIANCE_STRENTGH = 30.0F;
   protected float RESPONSE_ALLIANCE_OPINION = 50.0F;
   protected int SENT_MESSAGES_DEFAULT_TURNS = 20;
   protected float TECH_POP = 1.0F;
   protected float TECH_ECO = 1.0F;
   protected float TECH_TAXATION = 1.0F;
   protected float TECH_PRODUCTION = 1.0F;
   protected float TECH_ADMINISTARTION = 1.0F;
   protected float TECH_MILITARY_UPKEEP = 1.0F;
   protected float TECH_RESEARCH = 1.0F;
   protected float LIBERITY_ACCEPTABLE_TRIBUTE = 1.0F;
   protected float LIBERITY_DECLARATION = 75.0F;
   protected float VASSALS_TRIBUTE_PERC = 0.5F;
   protected float VASSALS_TRIBUTE_PERC_RAND = 0.5F;
   protected float VASSALS_TRIBUTE_PERC_FRIENDLY = 0.5F;
}
