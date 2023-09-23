package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;

public class Message_ProvincesOccupiedNotAtWar_LostControl extends Message {
   protected Message_ProvincesOccupiedNotAtWar_LostControl(int fromCivID, int iValue) {
      super(fromCivID, iValue);
      this.messageType = Message_Type.PROVINCES_LOST_CONTROL;
      this.iNumOfTurnsLeft = 2;
   }

   @Override
   protected void onAction(int iMessageID) {
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
         CFG.toast.setInView(CFG.langManager.get("LostControlOverProvince"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2);
         CFG.toast.setTimeInView(4500);
         CFG.game.setActiveProvinceID(this.iValue);
         if (!CFG.game.getProvince(CFG.game.getActiveProvinceID()).getDrawProvince()) {
            CFG.map.getMapCoordinates().centerToProvinceID(CFG.game.getActiveProvinceID());
         }
      }
   }

   @Override
   protected void onDecline(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         CFG.toast.setInView(CFG.langManager.get("LostControlOverProvince"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2);
         CFG.toast.setTimeInView(4500);
         CFG.game.setActiveProvinceID(this.iValue);
         if (!CFG.game.getProvince(CFG.game.getActiveProvinceID()).getDrawProvince()) {
            CFG.map.getMapCoordinates().centerToProvinceID(CFG.game.getActiveProvinceID());
         }
      }
   }

   @Override
   protected int getImageID() {
      return Images.provinces;
   }

   @Override
   protected int getBGImageID() {
      return Images.messages_r;
   }

   @Override
   protected MenuElement_Hover_v2 getHover() {
      List<MenuElement_Hover_v2_Element2> nElements = new ArrayList<>();
      List<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<>();
      nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("LostControlOverProvince") + ": ", CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getProvince(this.iValue).getName()));
      nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.provinces, CFG.PADDING, 0));
      nElements.add(new MenuElement_Hover_v2_Element2(nData));
      nData.clear();
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("RightfulOwner") + ":", CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
      nData.add(new MenuElement_Hover_v2_Element_Type_Flag(this.iFromCivID, CFG.PADDING, CFG.PADDING));
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getCiv(this.iFromCivID).getCivName()));
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
