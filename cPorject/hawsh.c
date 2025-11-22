//
// Created by ctind on 22.11.2025.
//
#include <stdio.h>
#include <pwd.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>



bool startsWith(char *string, char *what) {
    uint wl=strlen(what);

    uint sl=strlen(string);

    if (wl>sl)return false;


    return strncmp(string,what,wl)==0;

}
long getFirstSpace(char * str) {
    char *first_space = strchr(str, ' ');
    if (first_space != NULL) {
        return first_space - str;

    }
    return -1;
}


void main() {


    char *username = getenv("USER");
    char curentDir[2000];



    printf(curentDir);



    char lineIn[9002];


    while (true) {
        curentDir[0]=0;
        getcwd(curentDir,1998);
        printf("\n%s @ %s> ",username,curentDir);
        fflush(stdout);

        fgets(lineIn,sizeof(lineIn)-10,stdin);

        lineIn[8999]=0; //safty

        lineIn[strlen(lineIn)-1]=0; //remove newline

        if (startsWith(lineIn,"/")) {


            char* path=lineIn+1;
            int worked=chdir(path);

            if (worked<0) {
                printf("Unable to Locate path '%s'",lineIn);
            }
        }
        else if (strncmp(lineIn,"quit",4) == 0) {
            exit(0);
        }
        else {
            __pid_t PID=fork();
            if (PID<0) {
                printf("Error While Executing Command '%s'\n",lineIn);
                continue;
            }
            if (PID>0) {
                int status;

                int s=strlen(lineIn);

                if (lineIn[s-1]!='&') {
                    waitpid(PID,status,0);
                    printf("Child Process Exited with %i\n",status);

                }



            }else {
                char **argv1 = 0;

                long s=getFirstSpace(lineIn);

                lineIn[s]=0; //termainate arguments after that

                int st=strlen(lineIn);

                if (lineIn[st-1]=='&') {
                    lineIn[st-1]=0; // remove & for execution
                }
                int ret=execvp(lineIn,argv1);
                int r=0;
            }


        }


    }


}