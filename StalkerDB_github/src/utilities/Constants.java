/*
 * Copyright (c) 2005, tuxjsmith@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package utilities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import stalkerdb.StalkerDB;
import static utilities.Constants.RETURN_OBJECT.EDIT_ID_RETURN_OBJECT;
import static utilities.Constants.RETURN_OBJECT.VALIDATION_RETURN_OBJECT;

/**
 *
 * @author john
 */
public interface Constants {

    String VERSION = "0.80 (TODO: DVLA)";
    
    /*
     * Used by search and edit.
     */
    ConcurrentHashMap<String, String>
            SAVE_DB_RETURN_VALUES_HM = new ConcurrentHashMap(),
            SEARCH_DB_RETURN_VALUES_HM = new ConcurrentHashMap();

    ArrayList<String> IMAGES_SEARCH_DB_RETURN_VALUES_AL = new ArrayList<> ();
    
    enum GLOBAL_NOTES {
        
        LOADED (Boolean.FALSE);
        
        private Boolean active_b;
        
        GLOBAL_NOTES (Boolean b) {
            
            active_b = b;
        }
        
        public Boolean isActive () {
            
            return active_b;
        }
        
        public void setActive (Boolean b) {
            
            if (!active_b.equals ( b )) { 
                
                active_b = b;    
            }
        }
    }

    enum RETURN_TYPES {
        
        SEARCH,
        GLOBAL_NOTES,
        IMAGES,
        DEFAULT;
    }
    
    enum HTTP_METHODS {

        GET ("GET"),
        POST ("POST"),
        PUT ("PUT"),
        HEAD ("HEAD"),
        DELETE ("DELETE"),
        PATCH ("PATCH"),
        OPTIONS ("OPTIONS");

        private final String FOO;
        
        HTTP_METHODS (String s) {

            FOO = s;
        }
        
        public String getHttpMethodString () {
            
            return FOO;
        }
    }

    /*
     * TODO: message: make message and errorMessage lists.
     * They can be looped.
     */
    enum RETURN_OBJECT {

        VALIDATION_RETURN_OBJECT(),
        DATABASE_CONNECTIVITY_RETURN_OBJECT(),
        EDIT_ID_RETURN_OBJECT();

        private final StringBuilder message = new StringBuilder();
        private Boolean valid_b = Boolean.FALSE;

        RETURN_OBJECT() {
        }

        public void clearMessage() {

            message.setLength(0);
        }

        public void setTrue() {

            if (!valid_b) {

                valid_b = Boolean.TRUE;
            }
        }

        public void setFalse() {

            if (valid_b) {

                valid_b = Boolean.FALSE;
            }
        }

        public Boolean isTrue() {

            return valid_b;
        }

        public void appendMessage(String s) {

            message.append(s);
        }

        public void setMessage(String s) {

            clearMessage();

            message.append(s);
        }

        public String getMessage() {

            return message.toString();
        }
    }

    enum STATE {

        NEW_ENTRY_MODE (
            Boolean.TRUE,
            "New Entry Mode"),

        EDIT_MODE (
            Boolean.FALSE,
            "Edit Mode"),

        CLEARED (
            Boolean.FALSE,
            "Cleared, New Entry Mode"),

        SAVED (
            Boolean.FALSE,
            "Saved"),

        DELETED (
            Boolean.FALSE,
            "Deleted");

        private Boolean active;
        private final String MESSAGE;

        STATE (Boolean b,
               String msg) {

            active = b;
            MESSAGE = msg;
        }

        public String getMessage () {

            return MESSAGE;
        }

        public Boolean isActive () {

            return active;
        }

        private void deactivate () {

            active = Boolean.FALSE;
        }

        public void activate () {

            for (STATE state : STATE.values()) {

                state.deactivate();
            }

            active = Boolean.TRUE;

            switch (this) {

                case SAVED:

                    for (VALIDATION field : VALIDATION.values()) {

                        field.getSwingField().setEnabled(Boolean.FALSE);
                    }

                    StalkerDB.getDeleteBtn ().setEnabled (Boolean.FALSE);
                    StalkerDB.getSaveBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getFrontEditBtn().setEnabled (Boolean.TRUE);
                    StalkerDB.getUploadBtn().setEnabled(Boolean.FALSE);
                    StalkerDB.getTodayBtn().setEnabled(Boolean.FALSE);

                    break;

                case EDIT_MODE:

                    for (VALIDATION field : VALIDATION.values()) {

                        field.getSwingField().setEnabled(Boolean.TRUE);
                    }

                    StalkerDB.getDeleteBtn ().setEnabled (Boolean.TRUE);
                    StalkerDB.getSaveBtn().setEnabled (Boolean.TRUE);
                    StalkerDB.getFrontEditBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getUploadBtn().setEnabled(Boolean.TRUE);
                    StalkerDB.getTodayBtn().setEnabled(Boolean.TRUE);

                    StalkerDB.getDuplicatesLbl().setText("Duplicates");

                    break;

                case DELETED:

                    /*
                     * Why don't we want to do this ? (commented out)
                    */
//                    EDIT_ID_RETURN_OBJECT.setMessage ("0");

                    StalkerDB.getDeleteBtn ().setEnabled (Boolean.FALSE);
                    StalkerDB.getSaveBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getFrontEditBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getUploadBtn().setEnabled(Boolean.FALSE);
                    StalkerDB.getTodayBtn().setEnabled(Boolean.FALSE);

                    StalkerDB.getDuplicatesLbl().setText("Duplicates");

                    break;

                case CLEARED:

                    EDIT_ID_RETURN_OBJECT.setMessage ("0");

                    StalkerDB.getIdLbl().setText("ID");
                    StalkerDB.getDuplicatesLbl().setText("Duplicates");

                    for (VALIDATION field : VALIDATION.values()) {

                        field.getSwingField().setEnabled(Boolean.TRUE);
                    }

                    StalkerDB.getDeleteBtn ().setEnabled (Boolean.FALSE);
                    StalkerDB.getSaveBtn().setEnabled (Boolean.TRUE);
                    StalkerDB.getFrontEditBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getUploadBtn().setEnabled(Boolean.TRUE);
                    StalkerDB.getTodayBtn().setEnabled(Boolean.TRUE);

                    break;

                default:

                    for (VALIDATION field : VALIDATION.values()) {

                        field.getSwingField().setEnabled(Boolean.TRUE);
                    }

                    StalkerDB.getDeleteBtn ().setEnabled (Boolean.FALSE);
                    StalkerDB.getSaveBtn().setEnabled (Boolean.TRUE);
                    StalkerDB.getFrontEditBtn().setEnabled (Boolean.FALSE);
                    StalkerDB.getUploadBtn().setEnabled(Boolean.TRUE);
                    StalkerDB.getTodayBtn().setEnabled(Boolean.TRUE);

                    break;
            }
        }
        
        public static STATE getCurrentState () {
            
            for (STATE state : STATE.values()) {

                if (state.isActive()) {
                    
                    return state;
                }
            }
            
            return NEW_ENTRY_MODE;
        }
    }

    /**
     * A collection of GUI object references
     */
    enum VALIDATION {

        REGISTRATION("REGISTRATION",
                     "Alpha numeric.",
                     StalkerDB.getRegistrationTF(),
                     ".*\\p{ASCII}"),

        MAKE("MAKE",
             "Alpha numeric.",
             StalkerDB.getMakeTF(),
             ".*\\p{ASCII}"),

        /*
         * TODO: Parse time with a Calendar for validation.
         */
        TIME("TIME",
             "23:59:59",
             StalkerDB.getTimeTF(),
             "[0-9][0-9]:[0-9][0-9]:[0-9][0-9]"),

        /*
         * TODO: Parse date with a Calendar for validation.
         */
        DATE("DATE",
             "2019/01/02",
             StalkerDB.getDateTF(),
             "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]"),

        /*
         * TODO: replace
         */
        LOCATION("LOCATION",
                 "",
                 StalkerDB.getLocationTF(),
                 ".*\\p{ASCII}"),

        VIDEO_FILE("VIDEO FILE",
                   "",
                   StalkerDB.getVideoFileTF(),
                   ".*\\p{ASCII}"),

        NOTES("NOTES",
              "",
              StalkerDB.getNotesTA(),
//            "^((?!').)*$"); // https://www.regextester.com/15
              ".*\\p{ASCII}"),

        CRIME_STOPPERS("CRIME STOPPERS",
              "",
              StalkerDB.getCrimeStoppersCb(),
              ""),

        UPLOAD_IMAGE("UPLOAD IMAGE",
              "",
              StalkerDB.getUploadBtn(),
              ""),

        TODAY ("UPLOAD IMAGE",
              "",
              StalkerDB.getTodayBtn(),
              "");

        private final String NAME;
        private final String MESSAGE;
        private final String REGX;
        private Boolean valid = Boolean.TRUE;
        private final JComponent SWING_FIELD;

        VALIDATION (String name,
                    String msg,
                    JComponent field,
                    String regx) {

            NAME = name;
            MESSAGE = msg;
            SWING_FIELD = field;
            REGX = regx;
        }

        public JComponent getSwingField () {

            return SWING_FIELD;
        }

        public String getName () {

            return NAME;
        }

        public void validate() {

            if (this.equals(TIME)) {

                GregorianCalendar calendar = new GregorianCalendar(

                        2019,0,1,
                        Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[0]),
                        Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[1]),
                        Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[2])
                );

                Integer hour = calendar.get(Calendar.HOUR_OF_DAY),
                        minutes = calendar.get(Calendar.MINUTE),
                        seconds = calendar.get(Calendar.SECOND);

                if (hour.equals(Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[0]))
                    && minutes.equals(Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[1]))
                    && seconds.equals(Integer.parseInt( ((JTextComponent)TIME.getSwingField()).getText().replace(" ", "").split(":")[2]))) {

                }
                else {

                    setInvalid();
                }

                return;
            }

            if (this.equals(DATE)) {

                GregorianCalendar calendar = new GregorianCalendar(

                        Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[0]),
                        Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[1]) - 1,
                        Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[2]),
                        0,0,0
                );

                Integer year = calendar.get(Calendar.YEAR),
                        month = calendar.get(Calendar.MONTH),
                        day = calendar.get(Calendar.DAY_OF_MONTH);

                if (year.equals(Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[0]))
                    && month.equals((Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[1]) - 1 ))
                    && day.equals(Integer.parseInt( ((JTextComponent)DATE.getSwingField()).getText().replace(" ", "").split("-")[2]))) {

                }
                else {

                    setInvalid();
                }

                return;
            }

//            Pattern p = Pattern.compile (REGX);
//            Matcher m = p.matcher(getSwingField().getText().replace(" ", "").replace (System.getProperty ("line.separator"), "--linebreak--"));
//            if (!m.matches()) {

            if ( getSwingField() instanceof JTextComponent
                 && !((JTextComponent)getSwingField()).getText().replace(" ", "").replace (System.getProperty ("line.separator"), "--linebreak--").matches(REGX)) {

                setInvalid();
            }
        }

        public void resetValid () {

            valid = Boolean.TRUE;

            for (VALIDATION fields : VALIDATION.values()) {

                if ( !(fields.getSwingField() instanceof JButton) ) {

                    if (STATE.EDIT_MODE.isActive()) {

                        fields.getSwingField().setBorder(BorderFactory.createLineBorder(Color.green));

                        if (fields.getSwingField() instanceof JCheckBox) {

                            ((JCheckBox)fields.getSwingField()).setForeground(Color.green);
                        }
                    }
                    else {

                        fields.getSwingField().setBorder(BorderFactory.createLineBorder(Color.black));

                        if (fields.getSwingField() instanceof JCheckBox) {

                            ((JCheckBox)fields.getSwingField()).setForeground(new java.awt.Color(187, 187, 187));
                        }
                    }
                }
            }
        }

        public void setInvalid () {

            valid = Boolean.FALSE;

            getSwingField().setBorder(BorderFactory.createLineBorder(Color.red));

            VALIDATION_RETURN_OBJECT.setFalse();
            VALIDATION_RETURN_OBJECT.appendMessage(getName() + ": " + getMessage() + "<br>");
        }

        public Boolean isValid () {

            return valid;
        }

        public String getMessage () {

            return MESSAGE;
        }
    }
}
