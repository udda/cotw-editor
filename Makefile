# Copyright (C) 2011-2016 Mario Cianciolo <mr.udda@gmail.com>
# 
# This file is part of CotW Editor.
# 
# CotW Editor is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
# 
# CotW Editor is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
# 
# You should have received a copy of the GNU General Public License
# along with CotW Editor.  If not, see <http://www.gnu.org/licenses/>.


all: Main.class

run: all
	java -classpath javolution-core-java.jar:. Main

%.class: %.java
	javac -classpath javolution-core-java.jar:. -sourcepath . -Xlint:all -Xlint:-serial $^


.PHONY: clean
clean:
	find . -iname '*.class' | xargs rm -f
