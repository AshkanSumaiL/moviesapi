package com.ashkan.moviesapi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Member {
    private int memberId;
    private String name;
    private String username;
    private String telephone;
    private Collection<MovieRental> movieRentalsByMemberId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "member_id")
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId &&
                Objects.equals(name, member.name) &&
                Objects.equals(username, member.username) &&
                Objects.equals(telephone, member.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, username, telephone);
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<MovieRental> getMovieRentalsByMemberId() {
        return movieRentalsByMemberId;
    }

    public void setMovieRentalsByMemberId(Collection<MovieRental> movieRentalsByMemberId) {
        this.movieRentalsByMemberId = movieRentalsByMemberId;
    }
}
