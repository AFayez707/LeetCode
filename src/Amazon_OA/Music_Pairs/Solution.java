package Amazon_OA.Music_Pairs;

import java.util.ArrayList;
import java.util.List;

// Space: O(N)
// Time: O(N)
// Link: https://cybergeeksquad.co/2021/05/amazon-oa-2020-amazon-music-pairs-solutions.html

//Description
//        Amazon Music is working on a new "community radio station" feature which will allow users
//        to iteratively populate the playlist with their desired songs.
//        Considering this radio station will also have other scheduled shows to be aired
//        , and to make sure the community soundtrack will not run over other scheduled shows,
//        the user-submitted songs will be organized in full-minute blocks.
//        Users can choose any songs they want to add to the community list, but only in pairs of songs
//        with durations that add up to a multiple of 60 seconds (e.g. 60, 120, 180).
//        As an attempt to insist on the highest standards and avoid this additional burden on users,
//        Amazon will let them submit any number of songs they want, with any duration, and will handle
//        this 60-second matching internally. Once the user submits their list, given a list of song durations,
//        calculate the total number of distinct song pairs that can be chosen by Amazon Music.

public class Solution {
    int findNumberOfPairs(ArrayList<Integer> durations) {
        int numOfPairs = 0;

        int[] countOfEachDuration = new int[60];

        // Get the remainders of each song and store it.
        for(Integer duration : durations)
            countOfEachDuration[duration % 60]++;

        // Add each song to it's complement or corresponding song to produce a complete minute.
        for(int i = 1; i < 30; i++)
            numOfPairs += countOfEachDuration[i] * countOfEachDuration[60 - i];

        // Add the songs that's exactly in terms of minutes
        numOfPairs += countOfEachDuration[0] * (countOfEachDuration[0] - 1) / 2;

        // Add the songs that's exactly have 30 seconds.
        numOfPairs += countOfEachDuration[30] * (countOfEachDuration[30] - 1) / 2;

        return numOfPairs;
    }
}
