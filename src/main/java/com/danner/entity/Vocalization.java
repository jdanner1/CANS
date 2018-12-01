package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Vocalization() {

    }

    public Vocalization(User user, String text, String language, boolean isEmailed) {
        this.user = user;
        this.text = text;
        this.language = language;
        this.isEmailed = isEmailed;
        createTimestamp = LocalDateTime.now();
    }

    public int getVocalizationID() {
        return vocalizationID;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isEmailed() {
        return isEmailed;
    }

    public void setEmailed(boolean emailed) {
        isEmailed = emailed;
    }


    @Override
    public String toString() {
        return "Vocalization{" +
                "vocalizationID=" + vocalizationID +
                ", user=" + user +
                ", createDate=" + createTimestamp +
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

   /* @Override
    public int hashCode() {
        int result = vocalizationID;
        result = 31 * result + user.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + language.hashCode();
        result = 31 * result + (isEmailed ? 1 : 0);
        return result;
    }*/
}
