package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Slider_FlagAction_Clear_Flag_Tribute extends Slider {
   protected int iCivID;
   protected static final Color bgColor = new Color(0.0F, 0.0F, 0.0F, 0.3F);
   private String sTributePaid = "";
   private int iTributeWidth = 0;
   private Color oColorTribute = CFG.COLOR_INGAME_GOLD;
   private int iCivNameWidth = 0;

   protected Slider_FlagAction_Clear_Flag_Tribute(int iCivID, String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
      this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
      this.iCivID = iCivID;
      CFG.glyphLayout.setText(CFG.fontMain, sText);
      this.iCivNameWidth = (int)(CFG.glyphLayout.width * 0.8F);
   }

   @Override
   protected void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
      this.drawSliderBG_UpdateAnimation();
      oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE.r, CFG.COLOR_GRADIENT_TITLE_BLUE.g, CFG.COLOR_GRADIENT_TITLE_BLUE.b, 0.25F));
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            this.getWidth() + CFG.PADDING * 2,
            this.getHeight()
         );
      oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE.r, CFG.COLOR_GRADIENT_TITLE_BLUE.g, CFG.COLOR_GRADIENT_TITLE_BLUE.b, 0.8F));
      ImageManager.getImage(Images.patt)
         .draw2(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.patt).getHeight() + iTranslateY,
            this.getWidth() + CFG.PADDING * 2,
            this.getHeight()
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.55F));
      ImageManager.getImage(Images.gradient)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
            this.getWidth() + CFG.PADDING * 2,
            this.getHeight() * 3 / 5,
            false,
            false
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.275F));
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 4,
            this.getHeight(),
            false,
            false
         );
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + this.getWidth() + CFG.PADDING * 2 - this.getWidth() / 4 + iTranslateX,
            this.getPosY() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 4,
            this.getHeight(),
            true,
            false
         );
      oSB.setColor(new Color(CFG.COLOR_GRADIENT_TITLE_BLUE.r, CFG.COLOR_GRADIENT_TITLE_BLUE.g, CFG.COLOR_GRADIENT_TITLE_BLUE.b, 0.65F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() + 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth() + CFG.PADDING * 2,
            1
         );
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() - CFG.PADDING + iTranslateX,
            this.getPosY() + this.getHeight() - 2 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth() + CFG.PADDING * 2,
            1
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.175F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth(),
            this.getSliderHeight()
         );
      oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, this.getColorLEFT().a));
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            this.iCurrentPosX + this.iDifference_CurrentPosX,
            this.getSliderHeight()
         );
      ImageManager.getImage(Images.gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
            this.iCurrentPosX + this.iDifference_CurrentPosX,
            this.getSliderHeight()
         );
      oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, this.getColorLEFT().a * 0.92F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.iCurrentPosX + this.iDifference_CurrentPosX,
            this.getSliderHeight()
         );

      for(int i = 1; i < 10; ++i) {
         oSB.setColor(new Color(1.0F, 1.0F, 1.0F, 0.04F));
         ImageManager.getImage(Images.line_32_vertical)
            .draw2(
               oSB,
               this.getPosX() + this.getWidth() / 10 * i + iTranslateX,
               this.getPosY()
                  + this.getHeight()
                  - CFG.PADDING
                  - this.getSliderHeight()
                  - ImageManager.getImage(Images.line_32_vertical).getHeight()
                  + iTranslateY,
               1,
               this.getSliderHeight()
            );
      }

      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.65F));
      ImageManager.getImage(Images.gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
            this.getWidth(),
            CFG.PADDING
         );
      ImageManager.getImage(Images.gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - CFG.PADDING + 1 - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY,
            this.getWidth(),
            CFG.PADDING,
            false,
            true
         );
      oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.7F));
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            this.getWidth(),
            1
         );
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            this.getWidth(),
            1
         );
      if (isActive) {
         oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.045F));
         ImageManager.getImage(Images.line_32_off1)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
               this.getWidth(),
               1
            );
         ImageManager.getImage(Images.line_32_off1)
            .draw(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - CFG.PADDING - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
               this.getWidth(),
               1
            );
      }

      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.65F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING
               - this.getSliderHeight()
               + 1
               - ImageManager.getImage(Images.line_32_off1).getHeight()
               + iTranslateY,
            this.getWidth(),
            1
         );
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth(),
            1
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.65F));
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING
               - this.getSliderHeight()
               - 1
               - ImageManager.getImage(Images.pix255_255_255).getHeight()
               + iTranslateY,
            this.getWidth(),
            1
         );
      ImageManager.getImage(Images.pix255_255_255)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING + 1 - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY,
            this.getWidth(),
            1
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.8F));
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 8,
            1
         );
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 8,
            1
         );
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() + this.getWidth() - this.getWidth() / 8 + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - this.getSliderHeight() - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 8,
            1,
            true,
            false
         );
      ImageManager.getImage(Images.slider_gradient)
         .draw(
            oSB,
            this.getPosX() + this.getWidth() - this.getWidth() / 8 + iTranslateX,
            this.getPosY() + this.getHeight() - CFG.PADDING - ImageManager.getImage(Images.slider_gradient).getHeight() + iTranslateY,
            this.getWidth() / 8,
            1,
            true,
            false
         );
      oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.675F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING
               - this.getSliderHeight()
               + 1
               - ImageManager.getImage(Images.line_32_off1).getHeight()
               + iTranslateY,
            1,
            this.getSliderHeight() - 2
         );
      oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.55F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() - 1 + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING
               - this.getSliderHeight()
               + 1
               - ImageManager.getImage(Images.line_32_off1).getHeight()
               + iTranslateY,
            1,
            this.getSliderHeight() - 2
         );
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + 1 + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING
               - this.getSliderHeight()
               + 1
               - ImageManager.getImage(Images.line_32_off1).getHeight()
               + iTranslateY,
            1,
            this.getSliderHeight() - 2
         );
      oSB.setColor(Color.WHITE);

      try {
         CFG.game
            .getCiv(this.iCivID)
            .getFlag()
            .draw(
               oSB,
               this.getPosX() + CFG.PADDING + iTranslateX,
               this.getPosY()
                  + this.getHeight()
                  - CFG.PADDING * 2
                  - this.getSliderHeight()
                  - (int)((float)CFG.TEXT_HEIGHT * 0.8F) / 2
                  - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
                     / 2
                  - CFG.game.getCiv(this.iCivID).getFlag().getHeight()
                  + iTranslateY,
               (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight())),
               (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
            );
         ImageManager.getImage(Images.flag_rect)
            .draw(
               oSB,
               this.getPosX() + CFG.PADDING + iTranslateX,
               this.getPosY()
                  + this.getHeight()
                  - CFG.PADDING * 2
                  - this.getSliderHeight()
                  - (int)((float)CFG.TEXT_HEIGHT * 0.8F) / 2
                  - (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
                     / 2
                  - ImageManager.getImage(Images.flag_rect).getHeight()
                  + iTranslateY,
               (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight())),
               (int)((float)ImageManager.getImage(Images.flag_rect).getHeight() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
            );
      } catch (IndexOutOfBoundsException var7) {
      }

      CFG.fontMain.getData().setScale(0.8F);
      CFG.drawTextWithShadow(
         oSB,
         this.getText(),
         this.getPosX()
            + CFG.PADDING * 2
            + (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
            + iTranslateX,
         this.getPosY() + this.getHeight() - CFG.PADDING * 2 - this.getSliderHeight() - (int)((float)CFG.TEXT_HEIGHT * 0.8F) + iTranslateY,
         this.getColor(isActive)
      );
      CFG.fontMain.getData().setScale(0.7F);
      CFG.drawTextWithShadow(
         oSB,
         this.sTributePaid,
         this.getPosX()
            + this.iCivNameWidth
            + CFG.PADDING
            + CFG.PADDING * 2
            + (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
            + iTranslateX,
         this.getPosY()
            + this.getHeight()
            - CFG.PADDING * 2
            - this.getSliderHeight()
            - (int)((float)CFG.TEXT_HEIGHT * 0.7F) / 2
            - (int)((float)CFG.TEXT_HEIGHT * 0.8F) / 2
            + iTranslateY,
         this.oColorTribute
      );
      CFG.fontMain.getData().setScale(0.8F);
      CFG.drawTextWithShadow(
         oSB,
         this.getDrawText(),
         this.getPosX() + this.getWidth() - CFG.PADDING * 2 - (int)((float)this.getTextWidth() * 0.8F) + iTranslateX,
         this.getPosY() + this.getHeight() - CFG.PADDING * 2 - this.getSliderHeight() - (int)((float)CFG.TEXT_HEIGHT * 0.8F) + iTranslateY,
         CFG.COLOR_TEXT_OPTIONS_NS
      );
      ImageManager.getImage(Images.top_gold)
         .draw(
            oSB,
            this.getPosX()
               + this.iCivNameWidth
               + this.iTributeWidth
               + CFG.PADDING / 2
               + CFG.PADDING
               + CFG.PADDING * 2
               + (int)((float)ImageManager.getImage(Images.flag_rect).getWidth() * this.getImageScale(ImageManager.getImage(Images.flag_rect).getHeight()))
               + iTranslateX,
            this.getPosY()
               + this.getHeight()
               - CFG.PADDING * 2
               - this.getSliderHeight()
               - (int)((float)CFG.TEXT_HEIGHT * 0.8F) / 2
               - (int)((float)ImageManager.getImage(Images.top_gold).getHeight() * this.getImageScale(Images.top_gold, 0.7F)) / 2
               - ImageManager.getImage(Images.top_gold).getHeight()
               + iTranslateY,
            (int)((float)ImageManager.getImage(Images.top_gold).getWidth() * this.getImageScale(Images.top_gold, 0.7F)),
            (int)((float)ImageManager.getImage(Images.top_gold).getHeight() * this.getImageScale(Images.top_gold, 0.7F))
         );
      CFG.fontMain.getData().setScale(1.0F);
   }

   private final float getImageScale(int nImageHeight) {
      return (float)CFG.TEXT_HEIGHT / (float)nImageHeight < 1.0F ? (float)CFG.TEXT_HEIGHT / (float)nImageHeight : 1.0F;
   }

   @Override
   protected Color getColorLEFT() {
      try {
         return new Color(
            (float)CFG.game.getCiv(this.iCivID).getR() / 255.0F,
            (float)CFG.game.getCiv(this.iCivID).getG() / 255.0F,
            (float)CFG.game.getCiv(this.iCivID).getB() / 255.0F,
            0.525F
         );
      } catch (IndexOutOfBoundsException var2) {
         return new Color(CFG.COLOR_GRADIENT_TITLE_BLUE.r, CFG.COLOR_GRADIENT_TITLE_BLUE.g, CFG.COLOR_GRADIENT_TITLE_BLUE.b, 0.75F);
      }
   }

   protected Color getColor(boolean isActive) {
      return isActive ? new Color(0.71F, 0.71F, 0.71F, 1.0F) : (this.getIsHovered() ? new Color(0.82F, 0.82F, 0.82F, 1.0F) : Color.WHITE);
   }

   @Override
   protected String getDrawText() {
      return "" + this.getCurrent();
   }

   protected int getSliderHeight() {
      return CFG.PADDING * 3;
   }

   @Override
   protected void setCurrent(int nCurrent) {
      super.setCurrent(nCurrent);
      int tempTribute = (int)CFG.game_NextTurnUpdate.getIncome_Vassals(CFG.game.getCiv(this.iCivID).getPuppetOfCivID(), this.iCivID);
      this.sTributePaid = tempTribute > 0 ? "+" + CFG.getNumberWithSpaces("" + tempTribute) : "0";
      this.oColorTribute = tempTribute > 0 ? CFG.COLOR_INGAME_GOLD : CFG.COLOR_TEXT_MODIFIER_NEUTRAL2;
      CFG.glyphLayout.setText(CFG.fontMain, this.sTributePaid);
      this.iTributeWidth = (int)(CFG.glyphLayout.width * 0.7F);
   }

   @Override
   protected void actionElement(int iID) {
      int tempTribute = (int)CFG.game_NextTurnUpdate.getIncome_Vassals(CFG.game.getCiv(this.iCivID).getPuppetOfCivID(), this.iCivID);
      this.sTributePaid = tempTribute > 0 ? "+" + CFG.getNumberWithSpaces("" + tempTribute) : "0";
      this.oColorTribute = tempTribute > 0 ? CFG.COLOR_INGAME_GOLD : CFG.COLOR_TEXT_MODIFIER_NEUTRAL2;
      CFG.glyphLayout.setText(CFG.fontMain, this.sTributePaid);
      this.iTributeWidth = (int)(CFG.glyphLayout.width * 0.8F);
   }

   protected float getImageScale(int nImageID, float nTextScale) {
      return (float)CFG.TEXT_HEIGHT * nTextScale / (float)ImageManager.getImage(nImageID).getHeight();
   }
}
