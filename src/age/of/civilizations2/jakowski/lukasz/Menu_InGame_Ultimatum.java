/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Diplomacy_Demand;
import age.of.civilizations2.jakowski.lukasz.Button_Diplomacy_War_Cost;
import age.of.civilizations2.jakowski.lukasz.Button_FlagActionSliderStyle;
import age.of.civilizations2.jakowski.lukasz.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.DiplomacyManager;
import age.of.civilizations2.jakowski.lukasz.Game_Calendar;
import age.of.civilizations2.jakowski.lukasz.Game_Render_Province;
import age.of.civilizations2.jakowski.lukasz.ImageManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Text;
import age.of.civilizations2.jakowski.lukasz.Menu_InGame_OfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Menu_InGame_SelectProvinces;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.SliderMenuTitle;
import age.of.civilizations2.jakowski.lukasz.Slider_CrossTheBorder;
import age.of.civilizations2.jakowski.lukasz.SoundsManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import java.util.ArrayList;

class Menu_InGame_Ultimatum
extends SliderMenu {
    private int iOnCivID = -1;

    protected Menu_InGame_Ultimatum() {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADDING;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADDING, tY, true));
        tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight();
        int tempMenuPosY = ImageManager.getImage(Images.top_left2).getHeight() + CFG.PADDING * 2 + CFG.BUTTON_HEIGHT * 3 / 5;
        this.initMenu(new SliderMenuTitle(CFG.langManager.get("Ultimatum"), CFG.BUTTON_HEIGHT * 3 / 5, true, true), CFG.GAME_WIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING + tempMenuPosY > CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT - CFG.PADDING * 2 ? Math.max(CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT - CFG.PADDING * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 6) : ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING, menuElements, false, true);
        this.updateLanguage();
    }

    protected Menu_InGame_Ultimatum(final int onCivID) {
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        this.iOnCivID = onCivID;
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = 0;
        menuElements.add(new Button_Diplomacy_War_Cost(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID(), CFG.getActiveCivInfo(), 2, tY, CFG.BUTTON_WIDTH * 2){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }
        });
        menuElements.add(new Button_Diplomacy_Demand(CFG.langManager.get("DemandAnnexation"), CFG.getActiveCivInfo(), 2, tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight(), CFG.BUTTON_WIDTH * 2){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            protected void actionElement(int iID) {
                CFG.ultimatum.demandAnexation = !CFG.ultimatum.demandAnexation;
                CFG.ultimatum.demandProvinces.clear();
                if (CFG.ultimatum.demandAnexation) {
                    CFG.ultimatum.demandVasalization = false;
                }
            }

            @Override
            protected boolean getCheckboxState() {
                return CFG.ultimatum.demandAnexation;
            }

            @Override
            protected boolean getClickable() {
                return CFG.game.getCiv(onCivID).getPuppetOfCivID() == CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID();
            }

            @Override
            protected void buildElementHover() {
                if (CFG.game.getCiv(onCivID).getPuppetOfCivID() == CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()) {
                    this.menuElementHover = null;
                } else {
                    ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                    ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("YouCanDemandAnAnnexationOnlyFromYourVassal"), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_vassal, CFG.PADDING, 0));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                    this.menuElementHover = new MenuElement_Hover_v2(nElements);
                }
            }
        });
        tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight();
        if (CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID() != CFG.game.getCiv(onCivID).getPuppetOfCivID()) {
            menuElements.add(new Button_Diplomacy_Demand(CFG.langManager.get("DemandVassalization"), CFG.getActiveCivInfo(), 2, tY, CFG.BUTTON_WIDTH * 2){

                @Override
                protected int getWidth() {
                    return Menu_InGame_Ultimatum.this.getElementW() * 2;
                }

                @Override
                protected void actionElement(int iID) {
                    CFG.ultimatum.demandVasalization = !CFG.ultimatum.demandVasalization;
                    CFG.ultimatum.demandProvinces.clear();
                    if (CFG.ultimatum.demandVasalization) {
                        CFG.ultimatum.demandAnexation = false;
                    }
                }

                @Override
                protected boolean getCheckboxState() {
                    return CFG.ultimatum.demandVasalization;
                }
            });
            tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight();
        }
        menuElements.add(new Button_Diplomacy_Demand(CFG.langManager.get("DemandProvinces") + ": ", CFG.getActiveCivInfo(), 2, tY, CFG.BUTTON_WIDTH * 2){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            protected void actionElement(int iID) {
                CFG.ultimatum.demandAnexation = false;
                CFG.ultimatum.demandVasalization = false;
                if (CFG.ultimatum.demandProvinces.size() == 0) {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = onCivID;
                    CFG.game.getPlayer((int)CFG.PLAYER_TURNID).iACTIVE_VIEW_MODE = CFG.viewsManager.getActiveViewID();
                    CFG.viewsManager.disableAllViews();
                    CFG.game.setActiveProvinceID(-1);
                    Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.ULTIMATUM;
                    CFG.VIEW_SHOW_VALUES = false;
                    CFG.selectMode = true;
                    CFG.game.getSelectedProvinces().clearSelectedProvinces();
                    CFG.menuManager.setViewID(Menu.eINGAME_SELECT_PROVINCES);
                    Game_Render_Province.updateDrawProvinces();
                } else {
                    CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = onCivID;
                    CFG.game.getPlayer((int)CFG.PLAYER_TURNID).iACTIVE_VIEW_MODE = CFG.viewsManager.getActiveViewID();
                    CFG.viewsManager.disableAllViews();
                    CFG.game.setActiveProvinceID(-1);
                    Menu_InGame_SelectProvinces.typeOfAction = Menu_InGame_SelectProvinces.TypeOfAction.ULTIMATUM;
                    CFG.VIEW_SHOW_VALUES = false;
                    CFG.selectMode = true;
                    CFG.game.getSelectedProvinces().clearSelectedProvinces();
                    for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                        CFG.game.getSelectedProvinces().addProvince(CFG.ultimatum.demandProvinces.get(i));
                    }
                    CFG.menuManager.setViewID(Menu.eINGAME_SELECT_PROVINCES);
                    Game_Render_Province.updateDrawProvinces();
                }
            }

            @Override
            protected String getText() {
                return super.getText() + CFG.ultimatum.demandProvinces.size();
            }

            @Override
            protected boolean getCheckboxState() {
                return CFG.ultimatum.demandProvinces.size() > 0;
            }

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                if (CFG.ultimatum.demandProvinces.size() > 0) {
                    nData.add(new MenuElement_Hover_v2_Element_Type_Flag(onCivID));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("DemandProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                }
                for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(" - ", CFG.COLOR_TEXT_MODIFIER_NEUTRAL));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getProvince(CFG.ultimatum.demandProvinces.get(i)).getName()));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                }
                if (nElements.size() == 0) {
                    this.menuElementHover = null;
                    return;
                }
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Diplomacy_Demand(CFG.langManager.get("DemandMilitaryAccess"), CFG.getActiveCivInfo(), 2, tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight(), CFG.BUTTON_WIDTH * 2){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2;
            }

            @Override
            protected void actionElement(int iID) {
                CFG.ultimatum.demandMilitaryAccess = !CFG.ultimatum.demandMilitaryAccess;
            }

            @Override
            protected boolean getCheckboxState() {
                return CFG.ultimatum.demandMilitaryAccess;
            }
        });
        tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight();
        for (int i = 0; i < CFG.game.getCiv((int)onCivID).civGameData.lVassals.size(); ++i) {
            menuElements.add(new Button_Diplomacy_Demand(CFG.langManager.get("DemandLiberationOfVassal") + ": " + CFG.game.getCiv(CFG.game.getCiv((int)onCivID).civGameData.lVassals.get((int)i).iCivID).getCivName(), CFG.game.getCiv((int)onCivID).civGameData.lVassals.get((int)i).iCivID, 2, tY, CFG.BUTTON_WIDTH * 2){

                @Override
                protected int getWidth() {
                    return Menu_InGame_Ultimatum.this.getElementW() * 2;
                }

                @Override
                protected void actionElement(int iID) {
                    CFG.ultimatum.updateLiberationDemand(this.getCurrent());
                }

                @Override
                protected boolean getCheckboxState() {
                    return CFG.ultimatum.isLiberationDemanded(this.getCurrent());
                }
            });
            tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight();
        }
        menuElements.add(new Slider_CrossTheBorder(CFG.langManager.get("OrXUnitsWillInvade", 0), CFG.PADDING * 2, ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING, tempWidth - CFG.PADDING * 3 - CFG.BUTTON_WIDTH, CFG.TEXT_HEIGHT + CFG.PADDING * 2 + CFG.PADDING * 4, 0, CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getNumOfUnits(), 0, 0.65f){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() * 2 - CFG.PADDING * 4;
            }

            @Override
            protected int getSliderHeight() {
                return CFG.PADDING * 2;
            }

            @Override
            protected Color getColorLEFT() {
                return new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.65f);
            }
        });
        tY += ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING;
        menuElements.add(new Button_FlagActionSliderStyle(CFG.langManager.get("Cancel"), -1, 2 + CFG.PADDING, tY += CFG.PADDING, CFG.BUTTON_WIDTH, true){

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() - CFG.PADDING - CFG.PADDING / 2;
            }
        });
        menuElements.add(new Button_FlagActionSliderStyle(CFG.langManager.get("SendUltimatum"), -1, 2, tY, CFG.BUTTON_WIDTH, true){

            @Override
            protected int getPosX() {
                return Menu_InGame_Ultimatum.this.getElementW() + CFG.PADDING / 2;
            }

            @Override
            protected int getWidth() {
                return Menu_InGame_Ultimatum.this.getElementW() - CFG.PADDING - CFG.PADDING / 2;
            }

            @Override
            protected void buildElementHover() {
                ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                if (Game_Calendar.TURN_ID > 4) {
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("SendUltimatum") + ":", CFG.COLOR_BUTTON_GAME_TEXT_ACTIVE));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Flag(Menu_InGame_Ultimatum.this.iOnCivID, CFG.PADDING, CFG.PADDING));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getCiv(Menu_InGame_Ultimatum.this.iOnCivID).getCivName()));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                    if (CFG.ultimatum.canBeSend()) {
                        nData.add(new MenuElement_Hover_v2_Element_Type_Space());
                        nElements.add(new MenuElement_Hover_v2_Element2(nData));
                        nData.clear();
                        if (CFG.ultimatum.demandAnexation) {
                            nData.add(new MenuElement_Hover_v2_Element_Type_Flag(onCivID));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("DemandAnnexation"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                        }
                        if (CFG.ultimatum.demandVasalization) {
                            nData.add(new MenuElement_Hover_v2_Element_Type_Flag(onCivID));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("DemandVassalization"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                        }
                        if (CFG.ultimatum.demandProvinces.size() > 0) {
                            nData.add(new MenuElement_Hover_v2_Element_Type_Flag(onCivID));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("DemandProvinces"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                        }
                        for (int i = 0; i < CFG.ultimatum.demandProvinces.size(); ++i) {
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(" - ", CFG.COLOR_TEXT_MODIFIER_NEUTRAL));
                            nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.game.getProvince(CFG.ultimatum.demandProvinces.get(i)).getName()));
                            nElements.add(new MenuElement_Hover_v2_Element2(nData));
                            nData.clear();
                        }
                        nData.add(new MenuElement_Hover_v2_Element_Type_Flag(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()));
                        nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("OrXUnitsWillInvade", Menu_InGame_Ultimatum.this.getMenuElement(Menu_InGame_Ultimatum.this.getMenuElementsSize() - 3).getCurrent()), CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
                        nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_army, CFG.PADDING, 0));
                        nElements.add(new MenuElement_Hover_v2_Element2(nData));
                        nData.clear();
                    }
                } else {
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("AWarCantBeDeclaredInFirstXTurns", 4) + ".", CFG.COLOR_TEXT_MODIFIER_NEGATIVE2));
                    nData.add(new MenuElement_Hover_v2_Element_Type_Image(Images.diplo_war, CFG.PADDING, 0));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                }
                this.menuElementHover = new MenuElement_Hover_v2(nElements);
            }

            @Override
            protected void drawText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                ImageManager.getImage(Images.diplo_rivals).draw(oSB, this.getPosX() + this.getWidth() / 2 - (int)(((float)this.getTextWidth() * 0.8f + (float)ImageManager.getImage(Images.diplo_rivals).getWidth() + (float)CFG.PADDING) / 2.0f) + iTranslateX, this.getPosY() + this.getHeight() / 2 - ImageManager.getImage(Images.diplo_rivals).getHeight() / 2 + iTranslateY);
                CFG.fontMain.getData().setScale(0.8f);
                CFG.drawText(oSB, this.getText(), this.getPosX() + (this.getTextPos() < 0 ? this.getWidth() / 2 - (int)(((float)this.getTextWidth() * 0.8f + (float)ImageManager.getImage(Images.diplo_rivals).getWidth() + (float)CFG.PADDING) / 2.0f) + ImageManager.getImage(Images.diplo_rivals).getWidth() + CFG.PADDING : this.getTextPos()) + iTranslateX, this.getPosY() + this.getHeight() / 2 - (int)((float)this.getTextHeight() * 0.8f / 2.0f) + iTranslateY, this.getColor(isActive));
                CFG.fontMain.getData().setScale(1.0f);
            }

            @Override
            protected boolean getClickable() {
                return CFG.ultimatum.canBeSend() && Menu_InGame_Ultimatum.this.getMenuElement(Menu_InGame_Ultimatum.this.getMenuElementsSize() - 3).getCurrent() > 0 && CFG.game.getCiv(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()).getDiplomacyPoints() >= 24;
            }

            @Override
            protected int getSFX() {
                return this.getClickable() ? SoundsManager.SOUND_WAR : super.getSFX();
            }
        });
        int tempMenuPosY = ImageManager.getImage(Images.top_left2).getHeight() + CFG.PADDING * 2 + CFG.BUTTON_HEIGHT * 3 / 5;
        this.initMenu(new SliderMenuTitle(CFG.langManager.get("Ultimatum"), CFG.BUTTON_HEIGHT * 3 / 5, true, true){

            @Override
            protected void draw(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                ImageManager.getImage(Images.dialog_title).draw2(oSB, nPosX - 2 + iTranslateX, nPosY - this.getHeight() - ImageManager.getImage(Images.dialog_title).getHeight(), nWidth + 4 - ImageManager.getImage(Images.dialog_title).getWidth(), this.getHeight());
                ImageManager.getImage(Images.dialog_title).draw2(oSB, nPosX + nWidth + 2 - ImageManager.getImage(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeight() - ImageManager.getImage(Images.dialog_title).getHeight(), ImageManager.getImage(Images.dialog_title).getWidth(), this.getHeight(), true, false);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.165f));
                ImageManager.getImage(Images.line_32_off1).draw(oSB, nPosX + iTranslateX, nPosY - this.getHeight() + 2 - ImageManager.getImage(Images.line_32_off1).getHeight(), nWidth, this.getHeight() - 2, false, true);
                oSB.setColor(new Color(CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getR(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getG(), CFG.diplomacyColors_GameData.COLOR_DIPLOMACY_AT_WAR.getB(), 0.375f));
                ImageManager.getImage(Images.gradient).draw(oSB, nPosX + iTranslateX, nPosY - this.getHeight() * 2 / 3 - ImageManager.getImage(Images.gradient).getHeight(), nWidth, this.getHeight() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                ImageManager.getImage(Images.gradient).draw(oSB, nPosX + iTranslateX, nPosY - CFG.PADDING - ImageManager.getImage(Images.gradient).getHeight(), nWidth, CFG.PADDING, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                ImageManager.getImage(Images.pix255_255_255).draw(oSB, nPosX + iTranslateX, nPosY - 1 - ImageManager.getImage(Images.pix255_255_255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                ImageManager.getImage(Images.line_32_off1).draw(oSB, nPosX + iTranslateX, nPosY - 2 - ImageManager.getImage(Images.line_32_off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                ImageManager.getImage(Images.line_32_off1).draw(oSB, nPosX + iTranslateX, nPosY - 1 - ImageManager.getImage(Images.line_32_off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                ImageManager.getImage(Images.slider_gradient).draw(oSB, nPosX + iTranslateX, nPosY - 1 - ImageManager.getImage(Images.slider_gradient).getHeight(), nWidth / 2, 1);
                ImageManager.getImage(Images.slider_gradient).draw(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - ImageManager.getImage(Images.slider_gradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                CFG.fontMain.getData().setScale(0.8f);
                CFG.drawText(oSB, this.getText(), nPosX + (int)((float)nWidth - (float)this.getTextWidth() * 0.8f) / 2 + iTranslateX, 2 + nPosY - this.getHeight() + (int)((float)this.getHeight() - (float)this.getTextHeight() * 0.8f) / 2, Color.WHITE);
                CFG.fontMain.getData().setScale(1.0f);
            }
        }, CFG.GAME_WIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING + tempMenuPosY > CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT - CFG.PADDING * 2 ? Math.max(CFG.GAME_HEIGHT - CFG.BUTTON_HEIGHT - CFG.PADDING * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT + CFG.PADDING * 2) * 6) : ((MenuElement)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getHeight() + CFG.PADDING, menuElements, true, true);
        this.updateLanguage();
        Menu_InGame_OfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    protected void updateLanguage() {
    }

    @Override
    protected void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_OfferAlliance.lTime + 200L >= System.currentTimeMillis()) {
            Rectangle clipBounds = new Rectangle(this.getPosX() - 2, CFG.GAME_HEIGHT - this.getPosY(), this.getWidth() + 4, -((int)((float)(this.getHeight() + CFG.PADDING) * ((float)(System.currentTimeMillis() - Menu_InGame_OfferAlliance.lTime) / 200.0f))));
            oSB.flush();
            ScissorStack.pushScissors(clipBounds);
            oSB.setColor(Color.WHITE);
            ImageManager.getImage(Images.new_game_top_edge).draw2(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.new_game_top_edge).getHeight() + iTranslateY, this.getWidth() - ImageManager.getImage(Images.new_game_top_edge).getWidth() + 4, this.getHeight() + CFG.PADDING, false, true);
            ImageManager.getImage(Images.new_game_top_edge).draw2(oSB, this.getPosX() + 2 + this.getWidth() - ImageManager.getImage(Images.new_game_top_edge).getWidth() + iTranslateX, this.getPosY() - ImageManager.getImage(Images.new_game_top_edge).getHeight() + iTranslateY, ImageManager.getImage(Images.new_game_top_edge).getWidth(), this.getHeight() + CFG.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            ImageManager.getImage(Images.gradient).draw(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY, this.getWidth() - 4, this.getHeight() / 4);
            ImageManager.getImage(Images.pix255_255_255).draw(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY, this.getWidth() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.drawMenu(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            CFG.setRender_3(true);
            this.endClip(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        } else {
            oSB.setColor(Color.WHITE);
            ImageManager.getImage(Images.new_game_top_edge).draw2(oSB, this.getPosX() - 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.new_game_top_edge).getHeight() + iTranslateY, this.getWidth() - ImageManager.getImage(Images.new_game_top_edge).getWidth() + 4, this.getHeight() + CFG.PADDING, false, true);
            ImageManager.getImage(Images.new_game_top_edge).draw2(oSB, this.getPosX() + 2 + this.getWidth() - ImageManager.getImage(Images.new_game_top_edge).getWidth() + iTranslateX, this.getPosY() - ImageManager.getImage(Images.new_game_top_edge).getHeight() + iTranslateY, ImageManager.getImage(Images.new_game_top_edge).getWidth(), this.getHeight() + CFG.PADDING, true, true);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            ImageManager.getImage(Images.gradient).draw(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.gradient).getHeight() + iTranslateY, this.getWidth() - 4, this.getHeight() / 4);
            ImageManager.getImage(Images.pix255_255_255).draw(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - ImageManager.getImage(Images.pix255_255_255).getHeight() + iTranslateY, this.getWidth() - 4, 1);
            oSB.setColor(Color.WHITE);
            this.beginClip(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            this.drawMenu(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            oSB.setColor(Color.WHITE);
            this.endClip(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    protected void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    protected final void actionElement(int iID) {
        if (iID == this.getMenuElementsSize() - 1) {
            if (DiplomacyManager.sendUltimatum(this.iOnCivID, CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID(), CFG.ultimatum, this.getMenuElement(this.getMenuElementsSize() - 3).getCurrent())) {
                CFG.menuManager.updateInGame_TOP_All(CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID());
                CFG.toast.setInView(CFG.langManager.get("Sent") + "!", CFG.COLOR_TEXT_MODIFIER_POSITIVE);
                CFG.toast.setTimeInView(4500);
            }
            this.setVisible(false);
            return;
        }
        if (iID == this.getMenuElementsSize() - 2) {
            this.setVisible(false);
            return;
        }
        this.getMenuElement(iID).actionElement(iID);
    }

    protected final int getW() {
        return this.getWidth() - 4;
    }

    protected final int getElementW() {
        return this.getW() / 2;
    }

    @Override
    protected void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible) {
            for (int i = 0; i < this.getMenuElementsSize(); ++i) {
                this.getMenuElement(i).setVisible(false);
            }
        }
    }
}
