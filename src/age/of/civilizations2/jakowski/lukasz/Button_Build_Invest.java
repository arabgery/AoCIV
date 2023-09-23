package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Button_Build_Invest extends Button_Build {
   protected static final float FONTSIZE2 = 0.6F;
   protected String sProvinceName;
   protected String sDate;
   protected int iDateWidth;
   protected String sEconomy;
   protected int iEconomyWidth;

   protected Button_Build_Invest(String sText, String sProvinceID, int nImageID, int nCost, int nMovementCost, int iPosX, int iPosY, int iWidth) {
      super(sText, nImageID, nCost, nMovementCost, iPosX, iPosY, iWidth, true, false, 0, 0.0F);
      this.sProvinceName = sProvinceID;
      this.sDate = CFG.langManager.get("Economy") + ": ";
      CFG.glyphLayout.setText(CFG.fontMain, this.sDate);
      this.iDateWidth = (int)(CFG.glyphLayout.width * 0.6F);
      this.setMin(0);
   }

   @Override
   protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      ImageManager.getImage(this.iImageID)
         .draw(
            oSB,
            this.getPosX() + Button_Diplomacy.iDiploWidth / 2 - ImageManager.getImage(this.iImageID).getWidth() / 2 + iTranslateX,
            this.getPosY() + this.getHeight() / 2 - ImageManager.getImage(this.iImageID).getHeight() / 2 + iTranslateY
         );
      if (this.sCost.length() > 0 && this.sMovementCost.length() > 0) {
         if (this.sCost.length() > 0) {
            ImageManager.getImage(Images.top_gold)
               .draw(
                  oSB,
                  this.getPosX()
                     + this.getWidth()
                     - CFG.PADDING * 2
                     - (int)((float)ImageManager.getImage(Images.top_gold).getWidth() * this.getImageScale(Images.top_gold, 0.6F))
                     + iTranslateX,
                  this.getPosY()
                     + this.getHeight() / 2
                     - (int)((float)ImageManager.getImage(Images.top_gold).getHeight() * this.getImageScale(Images.top_gold, 0.6F))
                     - ImageManager.getImage(Images.top_gold).getHeight()
                     - CFG.PADDING / 2
                     + iTranslateY,
                  (int)((float)ImageManager.getImage(Images.top_gold).getWidth() * this.getImageScale(Images.top_gold, 0.6F)),
                  (int)((float)ImageManager.getImage(Images.top_gold).getHeight() * this.getImageScale(Images.top_gold, 0.6F))
               );
            CFG.fontMain.getData().setScale(0.6F);
            CFG.drawTextWithShadow(
               oSB,
               this.sCost,
               this.getPosX()
                  + this.getWidth()
                  - CFG.PADDING * 2
                  - (int)((float)ImageManager.getImage(Images.top_gold).getWidth() * this.getImageScale(Images.top_gold, 0.6F))
                  - CFG.PADDING
                  - this.iCostWidth
                  + iTranslateX,
               this.getPosY() + this.getHeight() / 2 - CFG.PADDING / 2 - (int)((float)this.getTextHeight() * 0.6F) + iTranslateY,
               this.canBuild_MoneyCost ? CFG.COLOR_INGAME_GOLD : CFG.COLOR_TEXT_MODIFIER_NEGATIVE2
            );
         }

         if (this.sMovementCost.length() > 0) {
            ImageManager.getImage(Images.top_movement_points)
               .draw(
                  oSB,
                  this.getPosX()
                     + this.getWidth()
                     - CFG.PADDING * 2
                     - (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F))
                     + iTranslateX,
                  this.getPosY() + this.getHeight() / 2 - ImageManager.getImage(Images.top_movement_points).getHeight() + CFG.PADDING / 2 + iTranslateY,
                  (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F)),
                  (int)((float)ImageManager.getImage(Images.top_movement_points).getHeight() * this.getImageScale(Images.top_movement_points, 0.6F))
               );
            CFG.fontMain.getData().setScale(0.6F);
            CFG.drawTextWithShadow(
               oSB,
               this.sMovementCost,
               this.getPosX()
                  + this.getWidth()
                  - CFG.PADDING * 2
                  - this.iMovementCostWidth
                  - (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F))
                  - CFG.PADDING
                  + iTranslateX,
               this.getPosY() + this.getHeight() / 2 + CFG.PADDING / 2 + iTranslateY,
               this.canBuild_Movement ? CFG.COLOR_INGAME_MOVEMENT : CFG.COLOR_TEXT_MODIFIER_NEGATIVE
            );
         }
      } else if (this.sMovementCost.length() > 0) {
         ImageManager.getImage(Images.top_movement_points)
            .draw(
               oSB,
               this.getPosX()
                  + this.getWidth()
                  - CFG.PADDING * 2
                  - (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F))
                  + iTranslateX,
               this.getPosY()
                  + this.getHeight() / 2
                  - ImageManager.getImage(Images.top_movement_points).getHeight()
                  - (int)((float)ImageManager.getImage(Images.top_movement_points).getHeight() * this.getImageScale(Images.top_movement_points, 0.6F)) / 2
                  + iTranslateY,
               (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F)),
               (int)((float)ImageManager.getImage(Images.top_movement_points).getHeight() * this.getImageScale(Images.top_movement_points, 0.6F))
            );
         CFG.fontMain.getData().setScale(0.6F);
         CFG.drawTextWithShadow(
            oSB,
            this.sMovementCost,
            this.getPosX()
               + this.getWidth()
               - CFG.PADDING * 2
               - this.iMovementCostWidth
               - (int)((float)ImageManager.getImage(Images.top_movement_points).getWidth() * this.getImageScale(Images.top_movement_points, 0.6F))
               - CFG.PADDING
               + iTranslateX,
            this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.6F) / 2 + iTranslateY,
            this.canBuild_Movement ? CFG.COLOR_INGAME_MOVEMENT : CFG.COLOR_TEXT_MODIFIER_NEGATIVE
         );
      }

      CFG.fontMain.getData().setScale(0.7F);
      CFG.drawTextWithShadow(
         oSB,
         this.getText(),
         this.getPosX() + CFG.PADDING + Button_Diplomacy.iDiploWidth + iTranslateX,
         this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.7F) - CFG.PADDING / 2 + iTranslateY,
         this.getColor(isActive)
      );
      CFG.drawTextWithShadow(
         oSB,
         this.sProvinceName,
         this.getPosX() + CFG.PADDING + Button_Diplomacy.iDiploWidth + (int)((float)this.getTextWidth() * 0.7F) + iTranslateX,
         this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.7F) - CFG.PADDING / 2 + iTranslateY,
         CFG.COLOR_TEXT_NUM_OF_PROVINCES
      );
      CFG.fontMain.getData().setScale(0.6F);
      CFG.drawTextWithShadow(
         oSB,
         this.sDate,
         this.getPosX() + CFG.PADDING + Button_Diplomacy.iDiploWidth + iTranslateX,
         this.getPosY() + this.getHeight() / 2 + CFG.PADDING / 2 + iTranslateY,
         CFG.COLOR_TEXT_OPTIONS_NS_HOVER
      );
      CFG.drawTextWithShadow(
         oSB,
         this.sEconomy,
         this.getPosX() + CFG.PADDING + Button_Diplomacy.iDiploWidth + this.iDateWidth + iTranslateX,
         this.getPosY() + this.getHeight() / 2 + CFG.PADDING / 2 + iTranslateY,
         CFG.COLOR_TEXT_ECONOMY
      );
      CFG.fontMain.getData().setScale(1.0F);
   }

   @Override
   protected void setMin(int iMin) {
      try {
         this.sEconomy = "+"
            + CFG.getNumberWithSpaces("" + iMin)
            + " [+"
            + CFG.getPercentage_Max100(iMin, CFG.game.getProvince(Menu_InGame_Invest.iProvinceID).getEconomy(), 4)
            + "%]";
      } catch (IndexOutOfBoundsException var3) {
         this.sEconomy = "+" + CFG.getNumberWithSpaces("" + iMin);
      } catch (ArithmeticException var4) {
         this.sEconomy = "+" + CFG.getNumberWithSpaces("" + iMin);
      }

      CFG.glyphLayout.setText(CFG.fontMain, this.sEconomy);
      this.iEconomyWidth = (int)(CFG.glyphLayout.width * 0.6F);
   }
}
