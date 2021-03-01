@echo off
echo start git tag
set tagName=V%date:~0,4%%date:~5,2%%date:~8,2%
echo tagName:%tagName%
git tag %tagName%
git push origin %tagName%
echo git tag success
