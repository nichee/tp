---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# MustVas User Guide
Welcome to MustVas's User Guide where you will be learning tips and tricks to make your experience with MustVas useful and handy. This User Guide will cover the main features of the app, as well as the relevant examples to get you started! Simply navigate to our [features section](#features) for a thorough read through, or click on a specific section to review in our [Table of Contents](#table-of-contents) for any queries you might have. Do keep a lookout for the frequently asked questions down below which may help you address some basic common questions! Lastly, our command summary will be useful as reference for the key command prompts to use in MustVas.

Having been built for TAs by TAs, MustVas is a desktop app designed to help fellow Teaching Assistants (TAs) manage tutorial contacts. Its key features include **creating and selecting classes, adding students' contacts and tracking their attendance**. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, MustVas can get your contact management tasks done faster than traditional GUI apps. We hope that MustVas will provide a new and better way for you to manage your students in the long run. Happy teaching!

NOTE: Users who are not familiar with using a CLI need not fret. Our commands have been specifically catered to a beginner's use - they are simple and easy to learn! Assistance is also provided automatically whenever there is an invalid command. 

<!-- * Table of Contents -->
## Table Of Contents
1. [Quick Start](#quick-start)
2. [Features](#features)
    - [Help](#viewing-help--help)
    - [Create class](#creating-a-class--create)
    - [Remove class](#removing-a-class--rm)
    - [View classes](#viewing-the-classes--view)
    - [Select class](#selecting-a-class-to-view--select)
      - [Add student](#adding-a-student--add)
      - [Delete student](#deleting-a-student--delete)
      - [Edit student](#editing-a-student--edit)
      - [Add attendance](#adding-an-attendance-record--adda)
      - [Delete attendance](#deleting-an-attendance-record--dela)
      - [Edit attendance](#editing-an-attendance-for-any-number-of-students--edita)
      - [Add/Edit description](#addingediting-a-description--description)
      - [List](#listing-a-class-to-view--list)
      - [Find](#locating-students-by-name--find)
      - [Clear](#clearing-all-entries--clear)
    - [Exit](#exiting-the-program--exit)
3. [Saving the data](#saving-the-data)
4. [Editing the data file](#editing-the-data-file)
5. [Coming Soon...](#coming-soon)
6. [Frequently Asked Questions](#faq)
7. [Known Issues](#known-issues)
8. [Command Summary](#command-summary)

<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `MustVas.jar` from [here](https://github.com/AY2324S2-CS2103T-T13-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your MustVas.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar MustVas.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. <br>
   ![Ui](images/UI_initial.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `view` : Lists all classes to select from.
  
   * `create c/CS2101` : Creates a class with course code `CS2101` in the Class Book.
  
   * `select 1` : Selects the specified class of index 1 from the class list.

   * `add n/John Doe p/98765432 e/johnd@example.com s/A0251980B` : Adds a student named `John Doe` to the Student Book.
  
   * `adda ar/01-01-2024` : Adds an attendance record with the date `01-01-2024` and a default status `1` to all the existing students.
  
   * `edita 1 ar/01-01-2024 st/0` : Edits the status of the attendance record with the date `01-01-2024` of the first student to `2`.
  
   * `dela ar/01-01-2024` : Deletes all the attendance record with the date `01-01-2024` from all the students.

   * `delete 1` : Deletes the 1st contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [p/PHONE_NUMBER]` can be used as `n/John Doe p/85018888` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/HelpCommand.png)

Format: `help`

### Creating a class : `create`

Simultaneously creates a class in the ClassBook and an empty StudentBook.

![CreateClassCommand](images/CreateClassCommand.png)

Format: `create c/CLASS_NAME`

Examples: 
* `create c/CS2101`: Creates a class with course code 'CS2101'.
* `create c/CS2103T`: Creates a class with course code 'CS2103T'.

### Removing a class : `rm`

Removes the specified class from the ClassBook.

Format: `rm INDEX`

* Deletes the class at the specified `INDEX`.
* The index refers to the index number shown in the displayed class list.
* The index **must be a positive integer** 1, 2, 3, …​
* Removes class from ClassBook and entire StudentBook from that class as well, i.e. [JAR file location]/data/classbook/[ClassName].json will be simultaneously deleted.

### Viewing the classes : `view`

Shows list of classes in result display.

![ViewCommand](images/ViewCommand.png)

Format: `view`

### Selecting a class to view : `select`

Shows a list of all students in the selected class.

![SelectCommand](images/SelectCommand.png)

Format: `select INDEX`

* The subsequent features (i.e. `add`, `delete`, `edit`, `adda`, `dela`, `edita`, `description`, `list`, `find`, `clear`) are to be used after selecting a class.

### Adding a student : `add`

Adds a student to the StudentBook.

![add_new_student_with_no_attendance](images/add_new_student_with_not_attendance.jpg)

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL s/STUDENT_ID [desc/DESCRIPTION]`

* `STUDENT_ID` must begin with A, followed by 7 digits, and end with a capital letter. 
* `PHONE_NUMBER` must range from `80000000` to `99999999`. 
* There should not be any duplicate `PHONE_NUMBER`, `EMAIL` or `STUDENT_ID`.
* The newly added student will be automatically positioned alphabetically by name.
* The description field is optional. You may write any description for the new student. However, **only one description is allowed**. The old description will be replaced with the new description.
* If there are existing attendance records allocated to the existing students, the newly added student will have a default status of '2' (meaning Valid Reason) for these existing attendance records. Please refer to the image below for illustration.
![add_new_student_with_attendance](images/add_new_student_with_attendance.PNG)

Examples:
* `add n/John Doe p/98765432 e/johnd@gmail.com s/A0251980B`: Adds a new student.
* `add n/John Doe p/98765432 e/johnd@gmail.com s/A0251980B desc/Enjoy coding`: Adds a new student with a description.

### Deleting a student : `delete`

Deletes the specified student from the StudentBook.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2`: Deletes the 2nd person in the StudentBook.
* `find Betsy` followed by `delete 1`: Deletes the 1st student in the results of the `find` command.

### Editing a student : `edit`

Edits an existing student in the StudentBook.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [s/STUDENT_ID]`

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* If the input values for `PHONE_NUMBER`, `EMAIL` and `STUDENT_ID` already exist (including the target user), the command will be rejected.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com`: Edits the phone number and email studentId of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower ar/`: Edits the name of the 2nd person to be `Betsy Crower` and clears all existing attendances.

### Adding an attendance record : `adda`

Add an attendance record to all existing students in the studentId book.

![add_attendance_command](images/add_attendance_command.png)

Format: `adda ar/DATE`

* The format for `DATE` is `dd-MM-yyyy`.
* The entered date, `DATE`, must not exist in any of the student's existing list of attendance dates.
* The newly added attendance record will be automatically sorted based on the date.
* The default value for status is '1' for 'Present', represented by a green tick.
* If a new student has been added and there are existing attendance record, using the `adda` command will produce a default status value of '2' for 'Valid Reason', represented by a blue dot.
* To edit the status value as well as more information on valid status inputs that we carry, do refer to the [`edita`](#editing-an-attendance-for-any-number-of-students--edita) command below for more information.
  
Examples:
*  `adda ar/01-01-2024`: All the existing students will have a newly added attendance with date `01-01-2024` and a default status `1`.

### Editing an attendance for any number of students : `edita`

Edits the existing attendance record in the student's list of attendance in the studentId book. **Any number of students** can be edited in one go.

![edit_attendance_command_mulitple](images/edit_attendance_command_mulitple.PNG)

Format: `edita INDEX1, INDEX2, …​ ar/DATE st/STATUS`

* The format for `DATE` is `dd-MM-yyyy`.
* Edits the student at the specified `INDEX(S)`. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​, up to the size of the class.
* The command requires at least one index to be present at a time, though **multiple indexes** is also allowed, the latter of which needs to be separated by commas.
* All the selected student will have their status of the selected attendance date, `DATE`, to be reflected to `STATUS`
  * The entered date, `DATE`, must exist in the student's existing list of attendance dates.
  * `STATUS`
    - 0 for 'Absent', represented by a red cross ❌ 
    - 1 for 'Present', represented by a green tick ✅ 
    - 2 for 'Valid Reason', represented by a blue dot 🔵 

Examples:
*  `edita 1 ar/01-01-2024 st/2`: Edits the attendance status of the 1st student for `01-01-2024` to `2`, indicating absence with a valid reason.
*  `edita 2, 3 ar/01-01-2024 st/0`: Edits the attendance status of the 2nd and 3rd student for `01-01-2024` to `0`, indicating absence.

### Deleting an attendance record : `dela`

Deletes the specified attendance date from all the student's list of attendance records in studentId book.

![delete_attendance_command](images/delete_attendance_command.png)

Format: `dela ar/DATE`

* The format for `DATE` is `dd-MM-yyyy`.
* The entered date, `DATE`, must exist in the student's existing list of attendance dates.
* Deletes the specified date, `DATE` from all the student's list of attendance records.

Examples:
* `dela ar/02-02-2024`: Deletes the attendance record, `02-02-2024`, from all students' existing list of attendance records.

### Editing an attendance for any number of students : `edita`

Edits the existing attendance record in the student's list of attendance in the studentId book. **Any number of students** can be edited in one go.

![edit_attendance_command_mulitple](images/edit_attendance_command_mulitple.PNG)

Format: `edita INDEX1, INDEX2, …​ ar/DATE st/STATUS`

* The format for `DATE` is `dd-MM-yyyy`.
* Edits the student at the specified `INDEX(S)`. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​, up to the size of the class.
* At least one index is provided. **Multiple number of index** is allowed at a time, separated by commas.
* All the selected student will have their status of the selected attendance date, `DATE`, to be reflected to `STATUS`
* The entered date, `DATE`, must exist in the student's existing list of attendance dates.

Examples:
*  `edita 1 ar/01-01-2024 st/2`: Edits the attendance status of the 1st student for `01-01-2024` to `2`, indicating absence with a valid reason.
*  `edita 2, 3 ar/01-01-2024 st/0`: Edits the attendance status of the 2nd and 3rd student for `01-01-2024` to `0`, indicating absence.

### Adding\Editing a description : `description`

Add a description to the selected student or Edit a description of the selected student.

![DescriptionCommand](images/DescriptionCommand.jpg)

Format: `description INDEX desc/DESCRIPTION`

* **Only one description is allowed**. The old description will be replaced with the new description.

Examples:
*  `description 1 desc/Loves coding`: Adds a description `Loves coding` to first student. 

### Listing a class to view : `list`

Lists all students in the class.

Format: `list`

### Locating students by name : `find`

Finds students whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `andrew` will match `Andrew`
* The order of the keywords does not matter. e.g. `Nic Faaheem` will match `Faaheem Nic`
* Only the name is searched.
* Only full words will be matched e.g. `andr` will not match `andrew`
* Students matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Tania Tan` will return `Tania Low`, `Tania Ooi`

Examples:
* `find andrew`: Returns `andrew` and `Andrew`

  ![Find example 1](images/FindCommandCapsInsensitive.png)
* `find nic faaheem` returns `nic`, `faaheem`<br>
  ![result for 'find nic faaheem'](images/FindExample2.png)

### Clearing all entries : `clear`

Clears all entries from the StudentBook in a selected class.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

ClassBook and StudentBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

ClassBook and StudentBook data are saved automatically as a JSON file `[JAR file location]/data/classbook.json` and `[JAR file location]/data/classbook/[ClassName].json` respectively. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, StudentBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the StudentBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Coming Soon...
**Clear All**: Instead of manually using the `rm` command to remove each individual class, or the `clear` command to clear the selected StudentBook, this feature will clear all data (including ClassBooks and their respective StudentBooks), increasing convenience for users.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

**Q**: How can I see the class that I am on right now? <br>
**A**: You can see the class that you have currently selected in the bottom left corner of the application (as shown below). <br>
![selected_class_showing](images/SelectedClassFAQ.png)

**Q**: How can I manually delete students/classes? <br>
**A**: Find your data folder in your home directory where MustVas is stored. In this folder, you will see the `classbook.json` file that contains, as well as another classbook folder that contains the individual `.json` files of the StudentBook, named after its class name. 
![manually delete class](images/ManuallyDeleteFiles.png)
- You may delete the individual StudentBook by deleting its individual .json file under the classbook folder. Do note that doing so will be akin to using the `clear` command on that class, effectively setting an empty StudentBook to be used.
- However, if you do intend to manually delete an entire class, do remember to delete both its _courseCode_ field in `classbook.json` and its respective `.json` file in the classbook folder. Otherwise, deleting just the _courseCode_ field in the `classbook.json` file would use the same `.json` file if a class of the same _courseCode_ got created again.


--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **When using view after selecting a class**, if you try to view classes after having selected a class, the StudentBook of the previously selected class will still be on display, until you select another class.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL s/STUDENT_ID [desc/DESCRIPTION]` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com s/A1111111D desc/Loves coding `
**Clear**  | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [s/STUDENT_ID]​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List**   | `list`
**Help**   | `help`
**View**   | `view`
**Select** | `select INDEX` <br> e.g., `select 1`
**Create** | `create c/CLASS_NAME` <br> e.g., `create c/CS2103`
**Remove** | `rm INDEX` <br> e.g., `rm 2`
**Add Attendance**   | `adda ar/DATE` <br> e.g., `adda ar/01-01-2024`
**Edit Attendance**  | `edita INDEX1, INDEX2, …​ ar/DATE st/STATUS` <br> e.g., `edita 1 ar/01-01-2024 st/2`
**Delete Attendance** | `dela ar/DATE` <br> e.g., `dela ar/02-02-2024`
**Add\Edit Description** | `description INDEX desc/DESCRIPTION` <br> e.g., `description 1 desc/Loves coding`
