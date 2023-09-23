package age.of.civilizations2.jakowski.lukasz;

class AI_Style_Fascism extends AI_Style {
   protected AI_Style_Fascism() {
      this.TAG = "FASCISM";
      this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.17F;
      this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 19;
      this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 68;
      this.PERSONALITY_MIN_HAPPINESS_RANDOM = 25;
      this.PERSONALITY_FORGIVNESS_DEFAULT = 0.9F;
      this.PERSONALITY_FORGIVNESS_RANDOM = 40;
   }

   @Override
   protected void buildStartingBuildings(int nCivID) {
      super.buildStartingBuildings(nCivID);

      try {
         if (CFG.game.getCiv(nCivID).getCapitalProvinceID() >= 0
            && CFG.game.getCiv(nCivID).getTechnologyLevel() >= BuildingsManager.getWorkshop_TechLevel(1) * 0.92F) {
            CFG.game
               .getProvince(CFG.game.getCiv(nCivID).getCapitalProvinceID())
               .setLevelOfWorkshop(Math.max(CFG.game.getProvince(CFG.game.getCiv(nCivID).getCapitalProvinceID()).getLevelOfWorkshop(), 1));
         }
      } catch (IndexOutOfBoundsException var3) {
         if (CFG.LOGS) {
            CFG.exceptionStack(var3);
         }
      }
   }
}
