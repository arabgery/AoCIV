package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_NewGameStyle_Middle extends Button {
   protected Button_NewGameStyle_Middle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
      super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, (int)((float)CFG.BUTTON_HEIGHT * 0.65F), isClickable, true, false, false);
   }

   protected Button_NewGameStyle_Middle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
      super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
   }

   @Override
   protected void drawButtonBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      if (isActive) {
         ImageManager.getImage(Images.new_game_box_line_hover)
            .draw2(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight() + iTranslateY,
               this.getWidth() - ImageManager.getImage(Images.new_game_box_line_hover).getWidth(),
               this.getHeight() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight()
            );
         ImageManager.getImage(Images.new_game_box_line_hover)
            .draw2(
               oSB,
               this.getPosX() + this.getWidth() - ImageManager.getImage(Images.new_game_box_line_hover).getWidth() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight() + iTranslateY,
               ImageManager.getImage(Images.new_game_box_line_hover).getWidth(),
               this.getHeight() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight(),
               true
            );
         ImageManager.getImage(Images.new_game_box_line_hover)
            .draw2(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight() * 2 + iTranslateY,
               this.getWidth() - ImageManager.getImage(Images.new_game_box_line_hover).getWidth(),
               ImageManager.getImage(Images.new_game_box_line_hover).getHeight(),
               false,
               true
            );
         ImageManager.getImage(Images.new_game_box_line_hover)
            .draw2(
               oSB,
               this.getPosX() + this.getWidth() - ImageManager.getImage(Images.new_game_box_line_hover).getWidth() + iTranslateX,
               this.getPosY() + this.getHeight() - ImageManager.getImage(Images.new_game_box_line_hover).getHeight() * 2 + iTranslateY,
               ImageManager.getImage(Images.new_game_box_line_hover).getWidth(),
               ImageManager.getImage(Images.new_game_box_line_hover).getHeight(),
               true,
               true
            );
      } else {
         ImageManager.getImage(Images.new_game_box_line)
            .draw2(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.new_game_box_line).getHeight() + iTranslateY,
               this.getWidth() - ImageManager.getImage(Images.new_game_box_line).getWidth(),
               this.getHeight() - ImageManager.getImage(Images.new_game_box_line).getHeight()
            );
         ImageManager.getImage(Images.new_game_box_line)
            .draw2(
               oSB,
               this.getPosX() + this.getWidth() - ImageManager.getImage(Images.new_game_box_line).getWidth() + iTranslateX,
               this.getPosY() - ImageManager.getImage(Images.new_game_box_line).getHeight() + iTranslateY,
               ImageManager.getImage(Images.new_game_box_line).getWidth(),
               this.getHeight() - ImageManager.getImage(Images.new_game_box_line).getHeight(),
               true
            );
         ImageManager.getImage(Images.new_game_box_line)
            .draw2(
               oSB,
               this.getPosX() + iTranslateX,
               this.getPosY() + this.getHeight() - ImageManager.getImage(Images.new_game_box_line).getHeight() * 2 + iTranslateY,
               this.getWidth() - ImageManager.getImage(Images.new_game_box_line).getWidth(),
               ImageManager.getImage(Images.new_game_box_line).getHeight(),
               false,
               true
            );
         ImageManager.getImage(Images.new_game_box_line)
            .draw2(
               oSB,
               this.getPosX() + this.getWidth() - ImageManager.getImage(Images.new_game_box_line).getWidth() + iTranslateX,
               this.getPosY() + this.getHeight() - ImageManager.getImage(Images.new_game_box_line).getHeight() * 2 + iTranslateY,
               ImageManager.getImage(Images.new_game_box_line).getWidth(),
               ImageManager.getImage(Images.new_game_box_line).getHeight(),
               true,
               true
            );
      }

      oSB.setColor(new Color(CFG.COLOR_INFO_BOX_GRADIENT.r, CFG.COLOR_INFO_BOX_GRADIENT.g, CFG.COLOR_INFO_BOX_GRADIENT.b, 0.215F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + 2 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth(),
            this.getHeight() - 4
         );
      oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.325F));
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB, this.getPosX() + iTranslateX, this.getPosY() + 1 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY, this.getWidth(), 1
         );
      ImageManager.getImage(Images.line_32_off1)
         .draw(
            oSB,
            this.getPosX() + iTranslateX,
            this.getPosY() + this.getHeight() - 2 - ImageManager.getImage(Images.line_32_off1).getHeight() + iTranslateY,
            this.getWidth(),
            1
         );
      oSB.setColor(Color.WHITE);
   }

   @Override
   protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
      if (isActive) {
         CFG.fontMain.getData().setScale(0.8F);
         CFG.drawText(
            oSB,
            this.getText(),
            this.getPosX() + (this.getTextPos() < 0 ? this.getWidth() / 2 - (int)((float)this.getTextWidth() * 0.8F / 2.0F) : this.getTextPos()) + iTranslateX,
            this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.8F / 2.0F) + iTranslateY,
            this.getColor(isActive)
         );
         CFG.fontMain.getData().setScale(1.0F);
      } else {
         CFG.fontMain.getData().setScale(0.8F);
         CFG.drawText(
            oSB,
            this.getText(),
            this.getPosX() + (this.getTextPos() < 0 ? this.getWidth() / 2 - (int)((float)this.getTextWidth() * 0.8F / 2.0F) : this.getTextPos()) + iTranslateX,
            this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.8F / 2.0F) + iTranslateY,
            this.getColor(isActive)
         );
         CFG.fontMain.getData().setScale(1.0F);
      }
   }

   @Override
   protected Color getColor(boolean isActive) {
      return CFG.getColor_CivInfo_Text(isActive, this.getIsHovered());
   }
}
