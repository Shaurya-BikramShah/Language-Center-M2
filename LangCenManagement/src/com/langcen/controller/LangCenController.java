package com.langcen.controller;

import com.langcen.model.LangCenModel;
import java.util.ArrayList;
import java.util.List;

public class LangCenController {
    private List<LangCenModel> studentSortList;

    public LangCenController() {
        studentSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of LangCenModel objects by their Student ID in ascending or descending order.
     *
     * @param studentList the list of LangCenModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<LangCenModel> sortByStudentId(List<LangCenModel> studentList, boolean isDesc) {
        this.studentSortList.clear();
        this.studentSortList.addAll(studentList);

        if (studentSortList == null || studentSortList.isEmpty()) {
            throw new IllegalArgumentException("Student list cannot be null or empty.");
        }

        for (int i = 0; i < studentSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(studentSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(studentSortList, i, extremumIndex);
            }
        }

        return studentSortList;
    }

    private int findExtremumIndex(List<LangCenModel> studentSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < studentSortList.size(); j++) {
            if (shouldSwap(studentSortList.get(j).getStudentId(), studentSortList.get(extremumIndex).getStudentId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    private void swap(List<LangCenModel> studentSortList, int i, int j) {
        LangCenModel temp = studentSortList.get(i);
        studentSortList.set(i, studentSortList.get(j));
        studentSortList.set(j, temp);
    }
    
}
