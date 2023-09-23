package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

class Message_InvestDone extends Message {
   protected Message_InvestDone(int fromCivID, int iValue) {
      super(fromCivID, iValue);
      this.messageType = Message_Type.INVEST_IS_OVER;
      this.iNumOfTurnsLeft = 2;
   }

   @Override
   protected void onAction(int iMessageID) {
      CFG.game.setActiveProvinceID(this.iValue);
      CFG.map.getMapCoordinates().centerToProvinceID(CFG.game.getActiveProvinceID());
      CFG.game
         .getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID())
         .getCivilization_Diplomacy_GameData()
         .messageBox
         .getMessage(iMessageID)
         .onDecline(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID());
      CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getCivilization_Diplomacy_GameData().messageBox.removeMessage(iMessageID);
      CFG.menuManager.rebuildInGame_Messages();
   }

   @Override
   protected void onAccept(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         List<String> lMess = new ArrayList<>();
         List<Color> lColors = new ArrayList<>();
         lMess.add(CFG.langManager.get("InvestmentInTheProvinceIsOver"));
         lColors.add(CFG.COLOR_TEXT_NUM_OF_PROVINCES);
         CFG.toast.setInView(lMess, lColors);
         CFG.toast.setTimeInView(6000);
      }
   }

   @Override
   protected void onDecline(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         List<String> lMess = new ArrayList<>();
         List<Color> lColors = new ArrayList<>();
         lMess.add(CFG.langManager.get("InvestmentInTheProvinceIsOver"));
         lColors.add(CFG.COLOR_TEXT_NUM_OF_PROVINCES);
         CFG.toast.setInView(lMess, lColors);
         CFG.toast.setTimeInView(6000);
      }
   }

   @Override
   protected int getImageID() {
      return Images.economy;
   }

   @Override
   protected int getBGImageID() {
      return Images.messages_g;
   }

   @Override
   protected MenuElement_Hover_v2 getHover() {
      List<MenuElement_Hover_v2_Element2> nElements = new ArrayList<>();
      List<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<>();
      nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID));
      nData.add(
         new MenuElement_Hover_v2_Element_Type_Text(
            (CFG.game.getProvince(this.iValue).getName().length() > 0 ? CFG.game.getProvince(this.iValue).getName() : CFG.langManager.get("Province")) + ": ",
            CFG.COLOR_TEXT_NUM_OF_PROVINCES
         )
      );
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("InvestmentInTheProvinceIsOver")));
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.economy, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("Economy") + ": "));
      nData.add(
         new MenuElement_Hover_v2_Element_Type_Text("" + CFG.getNumberWithSpaces("" + CFG.game.getProvince(this.iValue).getEconomy()), CFG.COLOR_TEXT_ECONOMY)
      );
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.economy, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Space());
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_message));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("MessageWillExpireIn") + ": "));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("TurnsX", this.iNumOfTurnsLeft) + " ", CFG.COLOR_TEXT_MODIFIER_NEUTRAL2));
      nData.add(
         new MenuElement_Hover_v2_Element_Type_Text(
            "[" + Game_Calendar.getDate_ByTurnID(Game_Calendar.TURN_ID + this.iNumOfTurnsLeft) + "]", CFG.COLOR_TEXT_MODIFIER_NEUTRAL
         )
      );
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      if (CFG.game.getCiv(this.iFromCivID).civGameData.leaderData != null) {
         nData.add(
            new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getCiv(this.iFromCivID).civGameData.leaderData.getName(), CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE)
         );
         nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID, CFG.PADDING, 0));
         nElements.add(new MenuElement_Hover_v2_Element2(nData));
         nData.clear();
      }

      return new MenuElement_Hover_v2(nElements);
   }
}
