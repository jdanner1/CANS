package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Vocalization")
@Table(name = "vocalization")
public class Vocalization {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "vocalizationID")
    private int vocalizationID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "create_timestamp")
    private LocalDate createTimestamp;

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
        createTimestamp = LocalDate.now();
    }

    public int getVocalizationID() {
        return vocalizationID;
    } //removed setVocalizationID since the db does this, assume ok

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public LocalDate getCreateDate() {
        return createTimestamp;
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
        if (createTimestamp != null ? !createTimestamp.equals(that.createTimestamp) : that.createTimestamp != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return language != null ? language.equals(that.language) : that.language == null;
    }

    @Override
    public int hashCode() {
        int result = vocalizationID;
        result = 31 * result + user.hashCode();
        result = 31 * result + (createTimestamp != null ? createTimestamp.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (isEmailed ? 1 : 0);
        return result;
    }
}
