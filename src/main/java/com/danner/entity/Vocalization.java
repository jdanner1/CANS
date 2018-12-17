package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jdanner
 * The type Vocalization.
 */
@Entity(name = "Vocalization")
@Table(name = "vocalization")
public class Vocalization {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "vocalizationID")
    private int vocalizationID;

    @ManyToOne
    @JoinColumn(name = "userID",
                foreignKey = @ForeignKey(name = "vocalization_user_userID"))
    private User user;

    @Column(name = "create_timestamp")
    private LocalDateTime createTimestamp;

    private String text;
    private String language;
    private boolean isEmailed;

    /**
     * Instantiates a new Vocalization.
     */
    public Vocalization() {

    }

    /**
     * Instantiates a new Vocalization.
     *
     * @param user      the user
     * @param text      the text
     * @param language  the language
     * @param isEmailed the is emailed
     */
    public Vocalization(User user, String text, String language, boolean isEmailed) {
        this.user = user;
        this.text = text;
        this.language = language;
        this.isEmailed = isEmailed;
        createTimestamp = LocalDateTime.now();
    }

    /**
     * Gets vocalization id.
     *
     * @return the vocalization id
     */
    public int getVocalizationID() {
        return vocalizationID;
    }


    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets create timestamp.
     *
     * @return the create timestamp
     */
    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Is emailed boolean.
     *
     * @return the boolean
     */
    public boolean isEmailed() {
        return isEmailed;
    }

    /**
     * Sets emailed.
     *
     * @param emailed the emailed
     */
    public void setEmailed(boolean emailed) {
        isEmailed = emailed;
    }


    @Override
    public String toString() {
        return "Vocalization{" +
                "vocalizationID=" + vocalizationID +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", language='" + language + '\'' +
                ", isEmailed=" + isEmailed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vocalization that = (Vocalization) o;

        if (vocalizationID != that.vocalizationID) return false;
        if (isEmailed != that.isEmailed) return false;
        if (!user.equals(that.user)) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return language.equals(that.language);
    }

}
