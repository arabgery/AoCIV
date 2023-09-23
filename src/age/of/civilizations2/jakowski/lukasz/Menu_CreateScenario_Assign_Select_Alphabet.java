/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Button_Menu_Active;
import age.of.civilizations2.jakowski.lukasz.Button_Menu_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuElement;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element2;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type;
import age.of.civilizations2.jakowski.lukasz.MenuElement_Hover_v2_Element_Type_Text;
import age.of.civilizations2.jakowski.lukasz.SliderMenu;
import age.of.civilizations2.jakowski.lukasz.SliderMenuTitle;
import java.util.ArrayList;
import java.util.List;

class Menu_CreateScenario_Assign_Select_Alphabet
extends SliderMenu {
    private List<Character> lCharacters;

    protected Menu_CreateScenario_Assign_Select_Alphabet() {
        int i;
        ArrayList<MenuElement> menuElements = new ArrayList<MenuElement>();
        if (CFG.chosen_AlphabetCharachter == null) {
            menuElements.add(new Button_Menu_Active(null, -1, 0, CFG.PADDING, CFG.BUTTON_HEIGHT, CFG.BUTTON_HEIGHT, true){

                @Override
                protected void buildElementHover() {
                    ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                    ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("AllCivilizations")));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                    this.menuElementHover = new MenuElement_Hover_v2(nElements);
                }
            });
        } else {
            menuElements.add(new Button_Menu_Classic(null, -1, 0, CFG.PADDING, CFG.BUTTON_HEIGHT, CFG.BUTTON_HEIGHT, true){

                @Override
                protected void buildElementHover() {
                    ArrayList<MenuElement_Hover_v2_Element2> nElements = new ArrayList<MenuElement_Hover_v2_Element2>();
                    ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                    nData.add(new MenuElement_Hover_v2_Element_Type_Text(CFG.langManager.get("AllCivilizations")));
                    nElements.add(new MenuElement_Hover_v2_Element2(nData));
                    nData.clear();
                    this.menuElementHover = new MenuElement_Hover_v2(nElements);
                }
            });
        }
        this.lCharacters = new ArrayList<Character>();
        for (i = 1; i < CFG.game.getCivsSize(); ++i) {
            boolean addChar = true;
            for (int a = 0; a < this.lCharacters.size(); ++a) {
                if (this.lCharacters.get(a).charValue() != CFG.game.getCiv(i).getCivName().charAt(0)) continue;
                addChar = false;
                break;
            }
            if (!addChar) continue;
            this.lCharacters.add(Character.valueOf(CFG.game.getCiv(i).getCivName().charAt(0)));
        }
        for (i = 0; i < this.lCharacters.size() - 1; ++i) {
            for (int j = i + 1; j < this.lCharacters.size(); ++j) {
                if (this.lCharacters.get(i).charValue() <= this.lCharacters.get(j).charValue()) continue;
                char temp = this.lCharacters.get(i).charValue();
                this.lCharacters.set(i, this.lCharacters.get(j));
                this.lCharacters.set(j, Character.valueOf(temp));
            }
        }
        for (i = 0; i < this.lCharacters.size(); ++i) {
            if (CFG.chosen_AlphabetCharachter != null && this.lCharacters.get(i).charValue() == CFG.chosen_AlphabetCharachter.charAt(0)) {
                menuElements.add(new Button_Menu_Active("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_HEIGHT * (i + 1), CFG.PADDING, CFG.BUTTON_HEIGHT, CFG.BUTTON_HEIGHT, true));
                continue;
            }
            menuElements.add(new Button_Menu_Classic("[" + this.lCharacters.get(i) + "]", -1, CFG.BUTTON_HEIGHT * (i + 1), CFG.PADDING, CFG.BUTTON_HEIGHT, CFG.BUTTON_HEIGHT, true));
        }
        if (((MenuElement)menuElements.get(menuElements.size() - 1)).getPosX() + ((MenuElement)menuElements.get(menuElements.size() - 1)).getWidth() < CFG.GAME_WIDTH) {
            int tempElementWidth = CFG.GAME_WIDTH / menuElements.size();
            int tempPosX = 0;
            for (int i2 = 0; i2 < menuElements.size() - 1; ++i2) {
                ((MenuElement)menuElements.get(i2)).setPosX(tempPosX);
                ((MenuElement)menuElements.get(i2)).setWidth(tempElementWidth);
                tempPosX += tempElementWidth;
            }
            ((MenuElement)menuElements.get(menuElements.size() - 1)).setPosX(tempPosX);
            ((MenuElement)menuElements.get(menuElements.size() - 1)).setWidth(CFG.GAME_WIDTH - tempPosX);
        }
        this.initMenu(new SliderMenuTitle(null, CFG.BUTTON_HEIGHT * 3 / 4, false, false), 0, CFG.BUTTON_HEIGHT * 3 / 4, CFG.GAME_WIDTH, CFG.BUTTON_HEIGHT + CFG.PADDING * 2, menuElements, true, false);
        this.updateLanguage();
    }

    @Override
    protected void updateLanguage() {
        this.getMenuElement(0).setText("[" + CFG.langManager.get("ALL") + "]");
        this.getTitle().setText(CFG.langManager.get("SelectCivilization"));
    }

    @Override
    protected final void actionElement(int iID) {
        switch (iID) {
            case 0: {
                CFG.chosen_AlphabetCharachter = null;
                CFG.menuManager.setViewID(Menu.eCREATE_SCENARIO_ASSIGN_SELECT);
                return;
            }
        }
        CFG.chosen_AlphabetCharachter = "" + this.lCharacters.get(iID - 1);
        CFG.menuManager.setViewID(Menu.eCREATE_SCENARIO_ASSIGN_SELECT);
    }
}
