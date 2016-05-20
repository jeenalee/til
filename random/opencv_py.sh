# Using homebrew is the easiest.
brew install opencv

# Say opencv is stored in: /usr/local/Cellar/opencv/2.4.10/

# Bind opencv to python.
cat ~/.bash_profile | grep PYTHONPATH
ln -s /usr/local/Cellar/opencv/2.4.10/lib/python2.7/site-packages/cv.py cv.py
ln -s /usr/local/Cellar/opencv/2.4.10/lib/python2.7/site-packages/cv2.so cv2.so
