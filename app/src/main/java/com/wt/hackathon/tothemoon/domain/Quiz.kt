package com.wt.hackathon.tothemoon.domain

import com.wt.hackathon.tothemoon.R

class Quiz {
    companion object {

        //Question 1
        val q1 = YesNoQuestion(1, "Request permission to re-enter society", "Continue", null, true)

        val q1a = SimpleCaptcha(10, "Rebel Captcha")

        //Question 2
        val q2 = ImageSetQuestion(2, "Select all parts of the face that should be covered.",
            listOf(
                Answer(1, R.drawable.image_part_001, false),
                Answer(2, R.drawable.image_part_002, false),
                Answer(3, R.drawable.image_part_003, false),
                Answer(4, R.drawable.image_part_004, false),
                Answer(5, R.drawable.image_part_005, true),
                Answer(6, R.drawable.image_part_006, false),
                Answer(7, R.drawable.image_part_007, false),
                Answer(8, R.drawable.image_part_008, true),
                Answer(9, R.drawable.image_part_009, true))
        )

        //Question 3
        val q3 = ImageSetQuestion(3, "Select all Irresponsibly Masked Humans",
            listOf(
                Answer(1, R.drawable.face_1, false),
                Answer(2, R.drawable.face_2, true),
                Answer(3, R.drawable.face_3, false),
                Answer(4, R.drawable.face_4, true),
                Answer(5, R.drawable.face_5, true),
                Answer(6, R.drawable.face_6, false),
                Answer(7, R.drawable.face_7, true),
                Answer(8, R.drawable.face_8, false),
                Answer(9, R.drawable.face_9, false))
        )

        //Question 4
        val q4 = YesNoQuestion(4, "Thank you for improving our Irresponsible Human Discovery Algorithm.", "Continue", null, true)


        //Question 5
        val q5 = YesNoQuestion(5, "Are you fully vaccinated?", "Yes", "No", true)

        //Question 6
        val q6 = YesNoQuestion(6, "Activate microchip to continue.", "Activate", null, true)

        //Question 7
        val q7 = YesNoQuestion(7, "Thank you for your cooperation. You are free to reenter society.", null, null, true)


        val allQuestions = listOf(q1, q1a, q2, q3, q4, q5, q6, q7)

    }
}