package com.wt.hackathon.tothemoon.domain

import com.wt.hackathon.tothemoon.R

class Quiz {
    companion object {

        //Question 1
        val q1 = Question.YesNoQuestion(1, "Request Permission to Reenter Society", true)

        //Question 2
        val q2 = Question.ImageSetQuestion(2, "Select all Irresponsibly Dressed Humans",
            listOf(
                Answer(1, R.drawable.image_part_001, true),
                Answer(2, R.drawable.image_part_002, false),
                Answer(3, R.drawable.image_part_003, true),
                Answer(4, R.drawable.image_part_004, true),
                Answer(5, R.drawable.image_part_005, true),
                Answer(6, R.drawable.image_part_006, false),
                Answer(7, R.drawable.image_part_007, true),
                Answer(8, R.drawable.image_part_008, true),
                Answer(8, R.drawable.image_part_009, true))
        )

        //Question 3
        val q3 = Question.ImageSetQuestion(3, "Select all Irresponsibly Spaced Humans",
            listOf(
                Answer(1, R.drawable.q3_a1, true),
                Answer(2, R.drawable.q3_a2, false),
                Answer(3, R.drawable.q3_a3, true),
                Answer(4, R.drawable.q3_a4, true),
                Answer(5, R.drawable.q3_a5, true),
                Answer(6, R.drawable.q3_a6, false),
                Answer(7, R.drawable.q3_a7, true),
                Answer(8, R.drawable.q3_a8, true),
                Answer(8, R.drawable.q3_a9, true))
        )

        //Question 4
        val q4 = Question.YesNoQuestion(4, "Thank you for improving GovLife's Irresponsible Human Discovery Algorithm.\u2028\u2028A few more questions...", true)


        //Question 5
        val q5 = Question.YesNoQuestion(4, "Are you vaccinated?\u2028Yes / No\u2028", true)

        //Question 6
        val q6 = Question.YesNoQuestion(4, "You are free to reenter society.\u2028\u2028Please wear pants.", true)


        val allQuestions = arrayOf(q1, q2, q3, q4, q5, q6)

    }
}