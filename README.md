# IUB_CSE213_CSC305_ObjectOrientedProgramming_Java_Projects_Summer2023
Welcome to the Java OOP Projects Collection repository! This repository serves as a comprehensive showcase of all the projects completed during the Object-Oriented Programming (OOP) course at Independent University Bangladesh.

#### Summer-23 -- CSE213 Coding Practice Problem-1 (Use of transaction class with file editing)
Version-1:
1. Design a FXML called AddFacultyScene.fxml for CITS admin to append new Faculty instances to
Faculty.bin binary file using ObjectOutputStream <br />
a. Private fields of Faculty: facultyId, name, designation, dept, salary, dateOfBirth. <br />
b. addNewFaculty() method of CITSAdmin model class is responsible for file writing. <br />
c. Handler method is responsible for showing feedback after successfully adding a new Faculty. <br />
2. Design a FXML called AddNewApprovedCourseScene.fxml for Registrar to append new approved
Course instances to Course.bin binary file using ObjectOutputStream. <br />
a. Private fields of Course: courseId, title, noOfCredits, courseType, courseCategory. <br />
b. addNewCourse() method of Registrar model class is responsible for file writing. <br />
c. Handler method is responsible for showing feedback after successfully adding a new Course. <br />
3. Design a FXML called OfferCourseForRegistrationScene.fxml for HoD to append new
OfferedCourse (normalized transaction class) instances to OfferedCourse.bin binary file using
ObjectOutputStream. <br />
a. Private fields of OfferedCourse:<br />
i. Private foreign fields: courseId, facultyId<br />
ii. Private non-foreign fields: sec, semester, days, room, time, capacity, enrolled<br />
iii. addNewOfferedCourse() method of HoD model class is responsible for file writing<br />
iv. Handler method is responsible for showing feedback after successfully adding a new
OfferedCourse<br />
<br />
b. While offering a course, the Scene will be pre-loaded with ALL Faculty ids with their names
from Faculty.bin, AND ALL Course ids with their titles from Course.bin, to facilitate HoD in
selecting a course and faculty for an OfferedCourse<br />

#### Copyright @ Subrata Kumar dey <br />

#### deyzone@gmail.com & subrata@iub.edu.bd Strictly Coding Strictly Coding - by Subrata Kumar Dey

#### Solveed by @Md Hasib Hasan

4. Design a FXML called CourseRegistrationScene.fxml for Student to append new
RegisteredCourse instances (normalized transaction class) to RegisteredCourse.bin binary file
using ObjectOutputStream <br />
a. Private foreign fields: courseId, courseId, semester, sec <br />
b. registerCourse() method of Student model class is responsible for file writing <br />
c. Handler method is responsible for showing feedback after the registration is done
successfully
