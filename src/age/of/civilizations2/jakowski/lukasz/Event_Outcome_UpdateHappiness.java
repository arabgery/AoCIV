package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Event_Outcome_UpdateHappiness extends Event_Outcome {
   protected int iCivID = -1;
   protected List<Integer> lProvinces = new ArrayList<>();
   protected int iValue = 0;

   @Override
   protected int getCivID() {
      return this.iCivID;
   }

   @Override
   protected void setCivID(int nCivID) {
      this.iCivID = nCivID;
   }

   @Override
   protected int getValue() {
      return this.iValue;
   }

   @Override
   protected void setValue(int nValue) {
      this.iValue = nValue;
   }

   @Override
   protected List<Integer> getProvinces() {
      return this.lProvinces;
   }

   @Override
   protected void setProvinces(List<Integer> nProvinces) {
      this.lProvinces.clear();

      for(int i = 0; i < nProvinces.size(); ++i) {
         this.lProvinces.add(nProvinces.get(i));
      }
   }

   @Override
   protected boolean updateCivIDAfterRemove(int nRemovedCivID) {
      if (this.iCivID == nRemovedCivID) {
         this.iCivID = -1;
         return true;
      } else {
         if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
         }

         return false;
      }
   }

   @Override
   protected void outcomeAction() {
      if (this.getCivID() >= 0 && this.getCivID() < CFG.game.getCivsSize()) {
         for(int i = 0; i < this.getProvinces().size(); ++i) {
            if (this.canMakeAction(i)) {
               CFG.game
                  .getProvince(this.getProvinces().get(i))
                  .setHappiness(CFG.game.getProvince(this.getProvinces().get(i)).getHappiness() + (float)this.getValue() / 100.0F);
            }
         }
      }
   }

   protected boolean canMakeAction(int i) {
      try {
         return !CFG.game.getProvince(this.getProvinces().get(i)).getSeaProvince()
            && CFG.game.getProvince(this.getProvinces().get(i)).getWasteland() < 0
            && CFG.game.getProvince(this.getProvinces().get(i)).getCivID() == this.getCivID();
      } catch (IndexOutOfBoundsException var3) {
         return false;
      }
   }

   @Override
   protected String getConditionText() {
      try {
         return CFG.langManager.get("UpdateHappiness")
            + ": "
            + CFG.game.getCiv(this.getCivID()).getCivName()
            + ", "
            + (this.getValue() > 0 ? "+" : "")
            + this.getValue();
      } catch (IndexOutOfBoundsException var2) {
         return CFG.langManager.get("UpdateHappiness");
      }
   }

   @Override
   protected List<MenuElement_Hover_v2_Element2> getHoverText() {
      try {
         List<MenuElement_Hover_v2_Element2> tElements = new ArrayList<>();
         List<MenuElement_Hover_v2_Element_Type> tData = new ArrayList<>();

         for(int i = 0; i < this.getProvinces().size(); ++i) {
            if (this.canMakeAction(i)) {
               tData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.getCivID()));
               tData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Happiness") + ": ", CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
               tData.add(
                  new MenuElement_Hover_v2_Element_Type_Text(
                     ""
                        + (
                           CFG.game.getProvince(this.getProvinces().get(i)).getName().length() == 0
                              ? (Serializable)this.getProvinces().get(i)
                              : CFG.game.getProvince(this.getProvinces().get(i)).getName()
                        )
                  )
               );
               tData.add(
                  new MenuElement_Hover_v2_Element_Type_Text(
                     " " + (this.getValue() > 0 ? "+" : "") + this.getValue() + "%",
                     this.getValue() > 0
                        ? CFG.COLOR_TEXT_MODIFIER_POSITIVE
                        : (this.getValue() == 0 ? CFG.COLOR_TEXT_MODIFIER_NEUTRAL2 : CFG.COLOR_TEXT_MODIFIER_NEGATIVE2)
                  )
               );
               tElements.add(new MenuElement_Hover_v2_Element2(tData));
               tData.clear();
            }
         }

         return tElements;
      } catch (IndexOutOfBoundsException var4) {
      } catch (NullPointerException var5) {
      }

      return new ArrayList<>();
   }

   @Override
   protected final void editViewID() {
      CFG.menuManager.setViewID(Menu.eCREATE_SCENARIO_EVENTS_OUT_HAPPINESS);
   }
}
