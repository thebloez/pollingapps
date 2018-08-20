package com.pollingapp.thebloez.repository;

import com.pollingapp.thebloez.model.ChoiceVoteCount;
import com.pollingapp.thebloez.model.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thebloez on 04/06/18.
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT NEW com.pollingapp.thebloez.model.ChoiceVoteCount(v.choice.id, count(v.id)) " +
            "from Vote v WHERE v.poll.id in :pollIds group by v.choice.id")
    List<ChoiceVoteCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);

    @Query("SELECT  NEW com.pollingapp.thebloez.model.ChoiceVoteCount(v.choice.id, count(v.id)) " +
            "from Vote v WHERE v.poll.id = :pollId group by v.choice.id")
    List<ChoiceVoteCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

    @Query("SELECT v from Vote v where v.user.id = :userId and v.poll.id in :pollIds")
    List<Vote> findByUserIdAndPollIdIn(
            @Param("userId") Long userId,
            @Param("pollIds") List<Long> pollIds);

    @Query("SELECT v from  Vote v where v.user.id = :userId and v.poll.id = :pollId")
    Vote findByUserIdAndPollId(@Param("userId") Long userId,
                               @Param("pollId") Long pollId);

    @Query("SELECT COUNT(v.id) from Vote v where v.user.id = :userId")
    long countByUserId(@Param("userId") Long userId);

    @Query("SELECT v.poll.id from Vote v where v.user.id = :userId")
    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}
