package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

class Message_Alliance_Accepted extends Message {
   protected Message_Alliance_Accepted(int fromCivID) {
      super(fromCivID, 0);
      this.messageType = Message_Type.ALLIANCE_ACCEPTED;
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
         List<String> lMess = new ArrayList<>();
         List<Color> lColors = new ArrayList<>();
         lMess.add(CFG.langManager.get("AllianceProposalAccepted"));
         lColors.add(CFG.COLOR_TEXT_MODIFIER_POSITIVE);
         CFG.toast.setInView(lMess, lColors);
         CFG.toast.setTimeInView(6000);
         CFG.menuManager.rebuildMenu_InGame_AllianceInfo(iCivID, this.iFromCivID);
      }
   }

   @Override
   protected void onDecline(int iCivID) {
      if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() == iCivID) {
         List<String> lMess = new ArrayList<>();
         List<Color> lColors = new ArrayList<>();
         lMess.add(CFG.langManager.get("AllianceProposalAccepted"));
         lColors.add(CFG.COLOR_TEXT_MODIFIER_POSITIVE);
         CFG.toast.setInView(lMess, lColors);
         CFG.toast.setTimeInView(6000);
         CFG.menuManager.rebuildMenu_InGame_AllianceInfo(iCivID, this.iFromCivID);
      }
   }

   @Override
   protected int getImageID() {
      return Images.diplo_alliance;
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
      nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("AllianceProposalAccepted"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
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
