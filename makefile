DEPENDENTS = Driver.java \
				RenderFrame.java \
				RenderPanel.java \
				Point3D.java \
				Cube.java


Driver:		$(DEPENDENTS)
			javac Driver.java

run:		Driver
			java Driver

clean:		
			rm *.class