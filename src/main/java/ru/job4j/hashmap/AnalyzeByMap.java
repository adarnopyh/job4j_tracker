package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int totalSubjectCounter = 0;
        double totalScore = 0.0D;
        for (Pupil pupil : pupils) {
            for (Subject entry : pupil.subjects()) {
                totalScore += entry.score();
                totalSubjectCounter++;
            }
        }
        return totalScore / totalSubjectCounter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> arrayOfLabels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int pupilSubjectsCounter = 0;
            double pupilTotalScore = 0.0d;
            for (Subject subject : pupil.subjects()) {
                pupilTotalScore += subject.score();
                pupilSubjectsCounter++;
            }
            arrayOfLabels.add(new Label(pupil.name(), pupilTotalScore / pupilSubjectsCounter));
        }
        return arrayOfLabels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> arrayOfLabels = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        int pupilCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.merge(subject.name(), subject.score(), Integer::sum);
            }
            pupilCount++;
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            arrayOfLabels.add(new Label(entry.getKey(), entry.getValue() / pupilCount));
        }
        return arrayOfLabels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> arrayOfLabels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double pupilTotalScore = 0.0d;
            for (Subject subject : pupil.subjects()) {
                pupilTotalScore += subject.score();
            }
            arrayOfLabels.add(new Label(pupil.name(), pupilTotalScore));
        }
        Label bestStudent = arrayOfLabels.get(0);
        for (Label label : arrayOfLabels) {
            if (bestStudent.score() < label.score()) {
                bestStudent = label;
            }
        }
        return bestStudent;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> arrayOfLabels = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            arrayOfLabels.add(new Label(entry.getKey(), entry.getValue()));
        }
        arrayOfLabels.sort(Comparator.naturalOrder());
        return arrayOfLabels.get(arrayOfLabels.size() - 1);
    }
}